package com.asmatech.book.controller;

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

import com.asmatech.book.entity.Auther;
import com.asmatech.book.entity.Book;
import com.asmatech.book.service.auther.AutherService;
import com.asmatech.book.service.book.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	BookService bookService; 
	
	@Autowired
	AutherService autherService;
	
	public Long getCount() {
		return bookService.getCount();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findBookById(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(bookService.findAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> addBook(@RequestBody @Valid Book book) {
		Auther auther = autherService.findById(book.getAuther().getId());
		book.setAuther(auther);
		return ResponseEntity.ok(bookService.insert(book)) ;
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody @Valid Book book) {
		return ResponseEntity.ok(bookService.update(book)) ;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		bookService.delete(id);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/auther/{id}")
	public int deleteByAutherId(@PathVariable Long id) {
		return bookService.deleteByAutherId(id);
	}
}
