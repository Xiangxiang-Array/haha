package test;

import entity.Dept;
import entity.Employee;
import service.DeptService;
import service.EmployeeService;
import service.impl.DeptServiceImpl;
import service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Test t=new Test();
		t.login();
	}


	public void login(){
		Scanner input=new Scanner(System.in);
		boolean jixu;
		do {
			//  提前声明登录失败
			jixu=false;
			System.out.println("---------部门账号登录---------");
			System.out.println("请输入部门：");
			String name=input.next();
			System.out.println("请输入密码：");
			String pwd=input.next();
			DeptService deptService=new DeptServiceImpl();
			Dept dept= deptService.login(name, pwd);
			if (dept!=null) {
				System.out.println("-----登录成功，部门信息-----");
				System.out.println("部门名称\t部门地址");
				System.out.println(dept.getDeptName()+"\t"+dept.getAddress());
				boolean jixu2=false;
				do {
					jixu2=true;
					System.out.println("---------------操作菜单--------------");
					System.out.println("0.退出系统");
					System.out.println("1.显示所有员工信息");
					System.out.println("2.显示该部门下员工信息");
					System.out.println("3.修改该部门的部门名称和办公地址");
					System.out.println("4.该部门下新增一名员工");
					System.out.println("5.根据员工姓名删除员工信息");
					System.out.println("6.删除该部门以及删除该部门下所有员工信息");
					System.out.println("----------------------------------");
					System.out.println("请选择操作选项:");
					int num=input.nextInt();
					switch (num) {
						case 0:
							System.out.println("退出系统");
							jixu2=false;
							break;
						case 1:
							//显示所有员工信息
							showEmpleesAlls();
							break;
						case 2:
							//显示所有员工信息
							showEmpleesAlls(dept);
							break;
						case 3:
							//修改该部门的部门名称和办公地址
							updateDeptInfo(dept);
							break;
						case 4:
							//该部门下新增一名员工
							addEmployee(dept);
							break;
						case 5:
							//根据员工姓名删除员工信息
							deleteEmployee();
							break;
						case 6:
							//删除该部门以及删除该部门下所有员工信息
							deleteDept(dept);
						default:
							break;
					}
				} while (jixu2);

			}else{
				System.out.println("用户名或密码错误!请重新登录");
			}
		} while (jixu);

	}




	private void deleteDept(Dept dept) {
		DeptService deptService=new DeptServiceImpl();
		boolean flag=deptService.delete(dept);
		if (flag) {
			System.out.println("删除"+dept.getDeptName()+"以及部门员工信息成功!");
		}else{
			System.out.println("删除部门以及部门员工信息失败!");
		}

	}


	private void deleteEmployee() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入员工姓名:");
		String delName=input.next();
		EmployeeService employeeService=new EmployeeServiceImpl();
		boolean flag=employeeService.deleteEmployee(delName);
		if (flag) {
			System.out.println("删除员工信息成功!");
		}else{
			System.out.println("删除员工信息失败!");
		}
	}


	private void addEmployee(Dept dept) {
		System.out.println("----------"+dept.getDeptName()+"下新增员工信息----------");
		EmployeeService employeeService=new EmployeeServiceImpl();
		boolean falg=employeeService.addEmployee(dept);
		if (falg) {
			System.out.println(dept.getDeptName()+"新增员工成功！");
		}else{
			System.out.println(dept.getDeptName()+"新增员工失败!");
		}
	}


	private void updateDeptInfo(Dept dept) {
		DeptService deptService=new DeptServiceImpl();
		boolean falg= deptService.updateDeptInfo(dept);
		if (falg) {
			System.out.println("修改部门信息成功！");
			Dept deptInfo=deptService.getDept(dept.getDeptNo());
			System.out.println("-----------------新的部门信息-----------");
			System.out.println("新的部门名称:"+deptInfo.getDeptName()+"\t新的部门办公地址:"+deptInfo.getAddress());
		}else{
			System.out.println("修改部门信息失败！");
		}
	}


	private void showEmpleesAlls(Dept dept) {
		EmployeeService employeeService=new EmployeeServiceImpl();
		List<Employee> employeeList= employeeService.getEmployeeBydept(dept);
		System.out.println("ID\t员工名称\t部门名称\t电话\t邮箱\t地址入职时间");
		for (Employee employee : employeeList) {
			System.out.println(employee.getId()+"\t"+employee.getName()+"\t"+employee.getDeptName()+"\t"
					+employee.getPhone()+"\t"+employee.getEmail()+"\t"
					+employee.getFormdate());
		}

	}

	private void showEmpleesAlls() {
		EmployeeService employeeService=new EmployeeServiceImpl();
		List<Employee> employeeList= employeeService.getEmployeeList();
		System.out.println("ID\t员工名称\t电话\t邮箱\t地址入职时间");
		for (Employee employee : employeeList) {
			System.out.println(employee.getId()+"\t"+employee.getName()+"\t"
					+employee.getPhone()+"\t"+employee.getEmail()+"\t"
					+employee.getFormdate());
		}

	}
}
