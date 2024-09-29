package com.sra.junit.plain;

import java.util.ArrayList;
import java.util.List;

import com.sra.junit.plain.pojo.Employee;

public class Programs {

	public Programs() {

	}

	private static List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;

	}

	public Employee getEmployee(String name) {

		for (Employee employee : employees) {
			if (employee.getEmployeeName().equalsIgnoreCase(name)) {
				return employee;
			}
		}
		return null;
	}

	public String addEmployee(Employee employee) {

		if (employee == null || employee.equals(null)) {
			return ("Employee is Null");
		} else {
			employees.add(employee);
			return "Added";
		}

	}

	public int getEmployeeCount() {
		if (employees.size() == 0)
			return 0;
		else
			return employees.size();

	}

	public String deleteEmployees() {
		if (employees.size() == 0)
			return "No Records";
		else {
			employees.clear();
			return "Deleted";
		}

	}

	public boolean isSame(Employee employee1, Employee employee2) {
		if (employee1.equals(employee2)) {
			return true;
		} else {
			return false;
		}
	}

	public void throwException(String number) throws Exception {
		if (number.length() == 0)
			throw new ArithmeticException("number is not valid");
		else
			throw new IllegalAccessException("throwing exception");
	}
}
