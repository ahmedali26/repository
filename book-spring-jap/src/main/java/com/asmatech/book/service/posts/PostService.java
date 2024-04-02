package com.asmatech.book.service.posts;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.asmatech.book.bean.PostEntity;

@Service
public class PostService {

	private static String POST_UTL="https://jsonplaceholder.typicode.com/posts";
	
	public PostEntity getPostById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<PostEntity> result= restTemplate.getForEntity(POST_UTL+"/"+id , PostEntity.class);
		
		return result.getBody();
		
	}
	
	public PostEntity[] getAllPosts() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<PostEntity[]> result= restTemplate.getForEntity(POST_UTL, PostEntity[].class);
		
		return result.getBody();
		
	}
	
	public PostEntity addPost(PostEntity post) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		headers.add("accept-language", "en");
		
		HttpEntity<PostEntity> request = new HttpEntity<>(post, headers);
		
		ResponseEntity<PostEntity> result= restTemplate.postForEntity(POST_UTL , request, PostEntity.class);
		
		return result.getBody();
		
	}
	
	public void updatePost(PostEntity post) {
		RestTemplate restTemplate = new RestTemplate();
			
		HttpEntity<PostEntity> request = new HttpEntity<>(post);
		
		restTemplate.put(POST_UTL , request, PostEntity.class);
		
	}
	
	public void deletePostById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.delete(POST_UTL+"/"+id , PostEntity.class);
		
	}
}
