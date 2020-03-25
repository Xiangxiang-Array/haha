package service.impl;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import entity.Dept;
import entity.Employee;
import service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDao employeeDao=new EmployeeDaoImpl();

	@Override
	public List<Employee> getEmployeeList() {
		String sql="SELECT e.id,e.name,d.deptName,e.phone,e.email,e.address,fromdate FROM employee e " +
				"INNER JOIN dept d ON d.deptNo=e.deptNo ";
		Object [] param=null;
		return employeeDao.employeeALLs(sql, param);
	}

	@Override
	public List<Employee> getEmployeeBydept(Dept dept) {
		String sql="SELECT e.id,e.name,d.deptName,e.phone,e.email,e.address,fromdate FROM Employee e " +
				"INNER JOIN dept d ON d.deptNo=e.deptNo   WHERE e.deptNo=?";
		Object [] param={dept.getDeptNo()};
		return employeeDao.employeeALLs(sql,param);
	}

	@Override
	public boolean addEmployee(Dept dept) {
		Scanner input=new Scanner(System.in);
		System.out.println("新增员工姓名:");
		String name=input.next();
		System.out.println("新增员工电话:");
		String phone=input.next();
		System.out.println("新增员工邮箱:");
		String email=input.next();
		System.out.println("新增员工地址:");
		String address=input.next();
		System.out.println("新增员工入职日期:");
		String formDate=input.next();
//		 Employee employee=new Employee(name, phone, email,dept.getDeptNo(),address, formDate);
//		 EmployeeDao employeeDao=new EmployeeDaoImpl();
//		 boolean flag=employeeDao.addEmployee(employee);
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		String sql="INSERT INTO Employee(NAME,phone,email,deptNo,address,fromdate) " +
				"VALUES(?,?,?,?,?,?);";
		Object [] param={name,phone,email,dept.getDeptNo(),address,formDate};
		if (employeeDao.executeUpdate(sql, param)>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(String delName) {
		EmployeeDaoImpl empDao=new EmployeeDaoImpl();
		String sql="DELETE FROM Employee WHERE NAME=?";
		Object [] param={delName};
		if (empDao.executeUpdate(sql, param)>0) {
			return true;
		}else{
			return false;
		}
	}

}
