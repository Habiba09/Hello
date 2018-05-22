package com.dss.dao;

import com.dss.bean.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    Connection con;

    public EmployeeDao() {
        con = DbConnection.doConnect();
    }

    public boolean insert(Employee emp_bean) {
        String insert = "insert into emp values(null,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, emp_bean.getEmp_name());
            ps.setString(2, emp_bean.getEmp_address());
            ps.setDouble(3, emp_bean.getEmp_salary());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Employee> getAllEmps() {
        List<Employee> empList = new ArrayList();
        String display = "select * from emp";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(display);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                double sal = rs.getDouble(4);
                Employee emp = new Employee(name, address, sal);
                emp.setEmp_id(id);

                empList.add(emp);
            }
        } catch (Exception e) {
        }
        return empList;
    }

    public boolean deletEmp(int idval) {
        String delete = "delete from emp where emp_id=" + idval;
        try {
            Statement st = con.createStatement();
            int count = st.executeUpdate(delete);
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public Employee getEmp(int idval) {
        Employee emp = new Employee();
        try {
            String query = "select * from emp where emp_id=" + idval;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                emp.setEmp_id(idval);
                emp.setEmp_name(rs.getString(2));
                emp.setEmp_address(rs.getString(3));
                emp.setEmp_salary(rs.getDouble(4));
                return emp;

            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean updateEmp(Employee emp_bean) {
        String update = "update emp set emp_name=?,emp_address=?,emp_salary=? where emp_id=?";
        try {
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, emp_bean.getEmp_name());
            ps.setString(2, emp_bean.getEmp_address());
            ps.setDouble(3, emp_bean.getEmp_salary());
            ps.setInt(4, emp_bean.getEmp_id());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

}
