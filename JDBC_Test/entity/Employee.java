package entity;

public class Employee {
	
	private int id;
	private String name;
	private String deptName;
	private String phone;
	private String email;
	private int deptNo;
	private String address;
	private String formdate;
	
//	name, phone, email,dept.getDeptNo(),address, formDate
	
	
	public int getId() {
		return id;
	}


	public Employee(String name, String phone, String email, int deptNo,
			String address, String formdate) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.deptNo = deptNo;
		this.address = address;
		this.formdate = formdate;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getDeptNo() {
		return deptNo;
	}




	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getFormdate() {
		return formdate;
	}




	public void setFormdate(String formdate) {
		this.formdate = formdate;
	}


	public Employee(int id, String name, String deptName,String phone, String email,
			String address, String formdate) {
		super();
		this.id = id;
		this.name = name;
		this.deptName=deptName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.formdate = formdate;
	}




	public Employee(int id, String name, String phone, String email, int deptNo,
			String address, String formdate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.deptNo = deptNo;
		this.address = address;
		this.formdate = formdate;
	}
	
	

}
