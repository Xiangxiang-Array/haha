package dao;

import java.util.List;

import entity.Employee;

public interface EmployeeDao {

	 List<Employee>  employeeALLs(String sql, Object[] param);

	boolean addEmployee(Employee employee);

	int deleteEmployee(int deptNo);

	
}
