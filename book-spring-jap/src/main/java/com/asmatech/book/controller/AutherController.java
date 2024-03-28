package com.asmatech.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asmatech.book.entity.Auther;
import com.asmatech.book.search.AutherSearch;
import com.asmatech.book.service.auther.AutherService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/authers")
@Validated
public class AutherController {

	@Autowired
	AutherService autherService; 
	
	public Long getCount() {
		return autherService.getCount();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findAutherById(@PathVariable @NotNull Long id) {
		return ResponseEntity.ok(autherService.findById(id));
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(autherService.findAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> addAuther(@RequestBody @Valid Auther auther) {
		return ResponseEntity.ok(autherService.insert(auther)) ;
	}

	@PutMapping("/udate")
	public ResponseEntity<?> updateAuther(@RequestBody @Valid Auther auther) {
		return ResponseEntity.ok(autherService.update(auther)) ;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAuther(@PathVariable Long id) {
		autherService.delete(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/spec")
	public ResponseEntity<?> findByAutherSpecification(@RequestBody AutherSearch search){
		return ResponseEntity.ok(autherService.findByAutherSpecification(search));
	}
}
