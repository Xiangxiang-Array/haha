package dao;

import entity.Dept;

public interface DeptDao {
	
	Dept login(String name,String password);

	Dept getDept(String sql, Integer deptNo);

	int deleteDept(int deptNo);
	
}
