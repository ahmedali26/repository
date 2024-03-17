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

import com.asmatech.hr.springdata.jpa.entity.Role;
import com.asmatech.hr.springdata.jpa.service.role.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/count")
	public Integer getRoleCount() {		
		return roleService.getCount();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable Integer id){
		return ResponseEntity.ok( roleService.findById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAll() {
		return ResponseEntity.ok(roleService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addRole(@RequestBody Role role) {
		return  ResponseEntity.ok(roleService.save(role));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateRole(@RequestBody Role role) {
		return  ResponseEntity.ok(roleService.save(role));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
		return ResponseEntity.ok(roleService.delete(id));
	}
	
	

}
