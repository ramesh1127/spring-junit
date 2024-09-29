package com.sra.junit.plain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sra.junit.plain.pojo.Employee;

public class ProgramsTest {

	private static Programs programs = null;

	@BeforeEach
	public void initilizeEmployee() {
		programs = new Programs();
	}

	// return type string test
	@Test
	public void addEmployeePassTest() {
		Employee employee = new Employee();
		employee.setEmployeeMobile("9000784494");
		employee.setEmployeeName("Ramesh");
		String response = programs.addEmployee(employee);
		Employee employee1 = new Employee();
		employee1.setEmployeeMobile("9553114494");
		employee1.setEmployeeName("Anjhi");
		String response1 = programs.addEmployee(employee);
		assertEquals("Added", response);

	}

	// return type string test
	@Test
	public void addEmployeeFailTest() {
		Employee employee = null;
		String response = programs.addEmployee(employee);
		assertEquals("Employee is Null", response);

	}

	// return type number test
	@Test
	public void getEmployeeCountFailTest() {
		programs.deleteEmployees();
		int response = programs.getEmployeeCount();
		assertEquals(0, response);

	}

	// return type number test
	@Test
	public void getEmployeeCountPassTest() {
		int response = programs.getEmployeeCount();
		assertEquals(response, response);

	}

	// return type number test
	@Test
	public void getEmployeeFailTest() {

		Employee response = programs.getEmployee("Suresh");

		assertEquals(null, response);

	}

	// return type number test
	@Test
	public void getEmployeePassTest() {
		addEmployeePassTest();
		List<Employee> result = programs.getEmployees();
		Employee response = programs.getEmployee("Ramesh");
		assertEquals(result.get(0), response);

	}

	// return type boolean test
	@Test
	public void isSameFailTest() {
		addEmployeePassTest();
		List<Employee> employees = programs.getEmployees();
		boolean response = programs.isSame(employees.get(0), employees.get(1));
		assertTrue(response);

	}

	// return type boolean test
	@Test
	public void isSamePassTest() {
		addEmployeePassTest();
		List<Employee> employees = programs.getEmployees();
		System.out.println("employees size>>>> " + employees.size());
		boolean response = programs.isSame(employees.get(0), employees.get(0));
		assertTrue(response);

	}

	// return type exception test
	@Test
	public void throwExceptionFailTest() {
		assertThrows(ArithmeticException.class, () -> programs.throwException(""));

	}

	// return type exception test
	@Test
	public void throwExceptionPassTest() {
		assertThrows(IllegalAccessException.class, () -> programs.throwException("0"));

	}
}
