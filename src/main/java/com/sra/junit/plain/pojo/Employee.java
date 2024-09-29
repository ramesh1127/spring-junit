package com.sra.junit.plain.pojo;

public class Employee {

	private String employeeName;
	private String employeeMobile;

	public Employee() {

	}

	public Employee(String employeeName, String employeeMobile) {
		super();
		this.employeeName = employeeName;
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeMobile=" + employeeMobile + "]";
	}

}
