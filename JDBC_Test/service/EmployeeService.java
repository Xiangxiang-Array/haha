package service;

import java.util.List;

import entity.Dept;
import entity.Employee;

public interface EmployeeService {

	List<Employee> getEmployeeList();

	List<Employee> getEmployeeBydept(Dept dept);

	boolean addEmployee(Dept dept);

	boolean deleteEmployee(String delName);

	
	
}
