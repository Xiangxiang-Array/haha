package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.EmployeeDao;
import entity.Employee;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao{

   Connection conn=null;
   PreparedStatement pstmt=null;
   ResultSet rs=null;
   
//	@Override
//	public List<Employee> employeeALLs() {
//		List<Employee> employeeList=new ArrayList<Employee>();
//		String sql="SELECT e.id,e.name,d.deptName,e.phone,e.email,e.address,fromdate FROM Employee e " +
//				"INNER JOIN dept d ON d.deptNo=e.deptNo";
//		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
//		conn=this.getConnection();
//		try {
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			while(rs.next()){
//				int id=rs.getInt("id");
//				String name=rs.getString("NAME");
//				String deptName=rs.getString("deptName");
//				String phone=rs.getString("phone");
//				String email=rs.getString("email");
//				String address=rs.getString("address");
//				String fromdate=sf.format(rs.getTimestamp("fromdate"));
//				Employee employee=new Employee(id, name,deptName,phone, email, address, fromdate);
//				employeeList.add(employee);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			this.closeAll(conn, pstmt, rs);
//		}
//		return employeeList;
//	}
   
   @Override
	public   List<Employee>  employeeALLs(String sql, Object[] param) {
	   List<Employee> employeeList=new ArrayList<Employee>();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			if (param!=null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject((i+1),param[i]);
				}
			}
			rs=pstmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("NAME");
				String deptName=rs.getString("deptName");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				String address=rs.getString("address");
				String fromdate=sf.format(rs.getTimestamp("fromdate"));
				Employee employee=new Employee(id, name,deptName,phone, email, address, fromdate);
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return employeeList;
	}
   
   @Override
	public boolean addEmployee(Employee employee) {
		 
		return false;
	}
   
   @Override
	public int deleteEmployee(int deptNo) {
		String sql="DELETE FROM Employee WHERE deptNo=?";
		Object[] param={deptNo};
		return this.executeUpdate(sql, param);
	}
}
