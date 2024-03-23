package com.asmatech.book.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.asmatech.book.entity.Auther;
import com.asmatech.book.entity.Book;
import com.asmatech.book.search.AutherSearch;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AutherSpecification implements Specification<Auther>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AutherSearch search;
	
	public AutherSpecification(AutherSearch search) {
		super();
		this.search = search;
	}

	@Override
	public Predicate toPredicate(Root<Auther> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		List<Predicate> predicates =new ArrayList<>();
		
		Join<Auther, Book> bookJoin = root.join("books", JoinType.LEFT);
		
		//search by name
		if(search.getAutherName() != null  && !search.getBookName().isEmpty()) {
			predicates.add(criteriaBuilder.like(root.get("name"),"%"+ search.getAutherName() +"%"));
		}
		
		
		// search by Email
		if(search.getEmail() != null  && !search.getBookName().isEmpty()) {
			predicates.add(criteriaBuilder.like(root.get("email"), search.getEmail()));
		}
		
		//search by IP address
		if(search.getIpAdderss() != null) {
			predicates.add(criteriaBuilder.like(root.get("ipAddress"), search.getIpAdderss()));
		}
		
		//search by bookName
		if(search.getBookName() != null && !search.getBookName().isEmpty()) {
			predicates.add(criteriaBuilder.like(bookJoin.get("name"), "%"+ search.getBookName() +"%"));
		}
		
		//search by price
		if(search.getPrice() != null) {
			predicates.add(criteriaBuilder.lessThanOrEqualTo(bookJoin.get("price"),  search.getPrice()));
		}
				
				
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

}
