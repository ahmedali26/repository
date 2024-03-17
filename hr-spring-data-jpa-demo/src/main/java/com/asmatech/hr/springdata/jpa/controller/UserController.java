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

import com.asmatech.hr.springdata.jpa.entity.User;
import com.asmatech.hr.springdata.jpa.service.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/count")
	public Integer getEmployeesCount() {		
		return userService.getCount();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id){
		return ResponseEntity.ok( userService.findById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		return  ResponseEntity.ok(userService.save(user));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		return  ResponseEntity.ok(userService.save(user));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		return ResponseEntity.ok(userService.delete(id));
	}
	
	
	@PutMapping("/roleToAll/{roleName}")
	public ResponseEntity<?> addRoleToAllUser(@PathVariable String roleName){
		userService.addRoleToAllUsers(roleName);
		return ResponseEntity.ok(null);
	}
	

}
