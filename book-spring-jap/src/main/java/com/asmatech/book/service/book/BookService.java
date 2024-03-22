package com.asmatech.book.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmatech.book.base.BaseService;
import com.asmatech.book.entity.Book;
import com.asmatech.book.repository.BookRepository;

@Service
public class BookService extends BaseService<Book, Long>{

	@Autowired
	BookRepository bookRepository;

	public int deleteByAutherId(Long id) {
		return bookRepository.deleteByAutherId(id);
	}
	
	

}
