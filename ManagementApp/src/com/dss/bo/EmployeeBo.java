package com.dss.bo;

import com.dss.bean.Employee;
import com.dss.dao.EmployeeDao;
import java.util.List;

public class EmployeeBo {

    EmployeeDao emp_dao = new EmployeeDao();

    public boolean insert(Employee emp_bean) {
        return emp_dao.insert(emp_bean);
    }

    public List<Employee> getAllEmps() {
        return emp_dao.getAllEmps();
    }

    public boolean deleteEmp(int idval) {
        return emp_dao.deletEmp(idval);
    }

    public Employee getEmp(int idval) {
     return emp_dao.getEmp(idval);
    }

    public boolean updateEmp(Employee emp_bean) {
    return emp_dao.updateEmp(emp_bean);
    }

}
