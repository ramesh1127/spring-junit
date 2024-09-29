package com.sra.junit.plain.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sra.junit.plain.pojo.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	public EmployeeController() {

	}

	private static List<Employee> employees = new ArrayList<Employee>();

	@GetMapping("/all")
	public List<Employee> getEmployees() {
		return employees;

	}

	@GetMapping("/get/{name}")
	public Employee getEmployee(@PathVariable String name) {

		for (Employee employee : employees) {
			if (employee.getEmployeeName().equalsIgnoreCase(name)) {
				return employee;
			}
		}
		return null;
	}

	@PostMapping("/create")
	public String addEmployee(@RequestBody Employee employee) {

		if (employee == null || employee.equals(null)) {
			return ("Employee is Null");
		} else {
			employees.add(employee);
			return "Added";
		}

	}

	@GetMapping("/count")
	public int getEmployeeCount() {
		if (employees.size() == 0)
			return 0;
		else
			return employees.size();

	}

	@DeleteMapping("/delete")
	public String deleteEmployees() {
		if (employees.size() == 0)
			return "No Records";
		else {
			employees.clear();
			return "Deleted";
		}

	}

	@PostMapping("/isSame")
	public boolean isSame(@RequestBody Employee employee1, @RequestBody Employee employee2) {
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
