package entity;

public class Dept {
	
	private int deptNo;
	private String deptName;
	private String password;
	private String address;
	
	
	public Dept(int deptNo, String deptName, String password, String address) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.password = password;
		this.address = address;
	}
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
