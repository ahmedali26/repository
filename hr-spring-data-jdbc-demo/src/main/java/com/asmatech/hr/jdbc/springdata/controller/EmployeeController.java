package com.asmatech.hr.jdbc.springdata.controller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asmatech.hr.jdbc.springdata.entity.Employee;
import com.asmatech.hr.jdbc.springdata.service.EmployeeSrvice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	EmployeeSrvice employeeService; 
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/count")
	public Integer getEmployeesCount() {
		
		return employeeService.getCount();
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id, @RequestHeader("accept-language") String acceptLong) {
		log.info("Accept Language is " + acceptLong);
		return ResponseEntity.ok(employeeService.findById(id)) ;
	}
	
	@GetMapping("/all")
	public List<Employee> getAll() {
		return employeeService.findAll();
	}
	
	@PostMapping("/save")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
//	@PostMapping("/edit")
//	public Employee editEmployee(@RequestBody Employee employee) {
//		return employeeService.save(employee);
//	}
	
	@DeleteMapping("/delete/{id}")
	public Integer deleteEmployee(@PathVariable Integer id) {
		return employeeService.delete(id);
	}
	
	@GetMapping("/filter/{salary}")
	public List<Employee> findBySalaryLessThan(@PathVariable Double salary){
		return employeeService.findBySalaryLessThan(salary);
	}
	
	@GetMapping("/getSqlEmp")
	public List<Employee> findEmployee(@RequestParam Date hireDate, @RequestParam Double salary){
		return employeeService.findEmployee(hireDate, salary);
	}
	
	@PutMapping("/updateSalary/{id}")
	public ResponseEntity<?> updateSalaryById(@RequestParam Double salary, @PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.updateSalaryById(salary, id));
	}
	
	public void testJackson() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString="{\r\n"
				+ "    \"id\": 5,\r\n"
				+ "    \"nameAr\": \"أالبراء عبد العظيم\",\r\n"
				+ "    \"nameEn\": \"Albaraa Abdul Eazeem\",\r\n"
				+ "    \"hierDate\": \"2019-07-01\",\r\n"
				+ "    \"salary\": 15500.0\r\n"
				+ "}";
		
		Employee emp =mapper.readValue(jsonString, Employee.class);
		
		jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
	}
}
