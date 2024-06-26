package com.asmatech.book.bean;

public class PostEntity {

	private Long id;
	
	private Long userId;
	
	private String title;
	
	private String body;
 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "PostEntity [id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
}
