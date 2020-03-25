package service.impl;

import dao.DeptDao;
import dao.EmployeeDao;
import dao.impl.DeptDaoImpl;
import dao.impl.EmployeeDaoImpl;
import entity.Dept;
import service.DeptService;

import java.util.Scanner;

public class DeptServiceImpl implements DeptService{

    DeptDaoImpl deptDao=new DeptDaoImpl();

    @Override
    public Dept login(String name, String password) {
        return deptDao.login(name, password);
    }

    @Override
    public boolean updateDeptInfo(Dept dept) {
        Scanner input=new Scanner(System.in);
        String sql="UPDATE dept SET deptName=?,address=? WHERE deptNo=?";
        System.out.println("请输入新的部门名称：");
        String deptName=input.next();
        System.out.println("请输入新的部门办公地址：");
        String deptAdress=input.next();
        Object [] param={deptName,deptAdress,dept.getDeptNo()};
        if (deptDao.executeUpdate(sql, param)>0) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Dept getDept(Integer deptNo) {
        Dept dept=null;
        String sql="SELECT * FROM dept WHERE deptNo=?";
        dept=deptDao.getDept(sql,deptNo);
        return dept;
    }

    @Override
    public boolean delete(Dept dept) {
        boolean flag=false;
        EmployeeDao employeeDao=new EmployeeDaoImpl();
        DeptDao deptDao=new DeptDaoImpl();
        if (employeeDao.deleteEmployee(dept.getDeptNo())>0) {
            System.out.println("删除学生成功....");
            if (deptDao.deleteDept(dept.getDeptNo())>0) {
                System.out.println("删除部门信息成功!");
                flag=true;
            }
        }
        return flag;
    }




}
