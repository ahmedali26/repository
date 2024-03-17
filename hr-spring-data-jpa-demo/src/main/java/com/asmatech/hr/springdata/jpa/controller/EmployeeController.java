package com.asmatech.hr.springdata.jpa.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asmatech.hr.springdata.jpa.entity.Employee;
import com.asmatech.hr.springdata.jpa.service.employee.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/count")
	public Integer getEmployeesCount() {		
		return employeeService.getCount();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id){
		return ResponseEntity.ok( employeeService.findById(id));
	}
	
	@GetMapping("/emp-dept")
	public ResponseEntity<?> findByEmpNameAndDeptName(@RequestParam String empName, @RequestParam String deptName){
		return ResponseEntity.ok(employeeService.findByEmpNameAndDeptName(empName, deptName));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAll() {
		return ResponseEntity.ok(employeeService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		return  ResponseEntity.ok(employeeService.save(employee));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return  ResponseEntity.ok(employeeService.save(employee));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.delete(id));
	}
	
	
	@GetMapping("/empInDept/{deptId}")
	public ResponseEntity<?> findByDepartmentId(@PathVariable Integer deptId){
		return ResponseEntity.ok(employeeService.findByDepartmentId(deptId));
	}
	
	@GetMapping("/hireDate")
	public ResponseEntity<?> findByhireDate(@RequestParam Date hireDate) {		
		return ResponseEntity.ok(employeeService.getByHireDate(hireDate));
	}
	
	@GetMapping("/hrStatistics")
	public ResponseEntity<?> getHRStatistics(){
		return ResponseEntity.ok(employeeService.getStatistics());
	}
	
	@GetMapping("/filter")
	public ResponseEntity<?> filterNative(@RequestParam String empName){
		return ResponseEntity.ok(employeeService.filterNative(empName));
	}
	

}
