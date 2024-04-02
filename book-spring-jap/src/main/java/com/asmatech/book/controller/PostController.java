package com.asmatech.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asmatech.book.service.posts.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPostById(@PathVariable Long id) {
		return ResponseEntity.ok(postService.getPostById(id));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getPosts() {
		return ResponseEntity.ok(postService.getAllPosts());
	}
}
