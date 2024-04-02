package com.asmatech.book.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Formula;

import com.asmatech.book.base.BaseEntity;
import com.asmatech.book.validate.IPAdderss;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "authers")
public class Auther extends BaseEntity{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auther_id")
	private Long id;
	
	@Column(name = "auther_name")
	@NotBlank(message = "Should be Enter Auther Name.")
	private String name;
	
//	@Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$")
	@IPAdderss()
	private String ipAddress;
	
	@Email(message = "{validation.email.Pattern.message}")
	private String email;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Formula("(select count(*) from books b where b.auther_id = auther_id)")
	private Integer bookCount;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "auther")
	@JsonManagedReference
	private List<Book>books = new ArrayList<>();
	
	public Auther() {
		super();
	}

	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getBookCount() {
		return bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Auther [id=" + id + ", name=" + name + "]";
	}

	
}
