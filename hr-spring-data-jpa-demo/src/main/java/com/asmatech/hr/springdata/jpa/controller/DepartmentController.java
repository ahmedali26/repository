package com.asmatech.hr.springdata.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asmatech.hr.springdata.jpa.entity.Department;
import com.asmatech.hr.springdata.jpa.service.department.DepartmentService;

@RestController
@RequestMapping("/depts")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/count")
	public Integer getDepartmentCount() {		
		return departmentService.getCount();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable Integer id){
		return ResponseEntity.ok( departmentService.findById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAll() {
		return ResponseEntity.ok(departmentService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addDepartment(@RequestBody Department department) {
		return  ResponseEntity.ok(departmentService.save(department));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDepartment(@RequestBody Department department) {
		return  ResponseEntity.ok(departmentService.save(department));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Integer id) {
		return ResponseEntity.ok(departmentService.delete(id));
	}
	
	
	
	

}
