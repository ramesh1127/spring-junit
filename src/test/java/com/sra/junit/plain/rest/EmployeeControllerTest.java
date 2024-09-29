package com.sra.junit.plain.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sra.junit.plain.pojo.Employee;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void getEmployeesTest() throws Exception {

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/employee/all");
		ResultActions result = mockMvc.perform(requestBuilder);
		MvcResult response = result.andReturn();
		MockHttpServletResponse res = response.getResponse();
		System.out.println(res.getContentAsString());
		int status = res.getStatus();
		assertEquals(200, status);
	}
	@Test
	public void addEmployeesTest() throws Exception {

		Employee employee = new Employee();
		employee.setEmployeeMobile("9000784494");
		employee.setEmployeeName("Ramesh");
		Employee employee1 = new Employee();
		employee1.setEmployeeMobile("9553114494");
		employee1.setEmployeeName("Anjhi");
		
		ObjectMapper objectMapper=new ObjectMapper();
		String employee1String = objectMapper.writeValueAsString(employee1);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/employee/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(employee1String);
		ResultActions result = mockMvc.perform(requestBuilder);
		MvcResult response = result.andReturn();
		MockHttpServletResponse res = response.getResponse();
		System.out.println(res.getContentAsString());
		int status = res.getStatus();
		assertEquals(200, status);
	}
	
	
	
	

}
