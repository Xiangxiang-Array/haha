package service;

import entity.Dept;

public interface DeptService {
	
	Dept login(String name,String password);

	
	boolean updateDeptInfo(Dept dept);




	Dept getDept(Integer deptNo);


	boolean delete(Dept dept);



}
