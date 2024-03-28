package com.asmatech.book.service.book;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.asmatech.book.base.BaseService;
import com.asmatech.book.entity.Book;
import com.asmatech.book.repository.BookRepository;

@Service
public class BookService extends BaseService<Book, Long>{

	@Autowired
	BookRepository bookRepository;

	Logger log = LoggerFactory.getLogger(BookService.class);
	
	public int deleteByAutherId(Long id) {
		return bookRepository.deleteByAutherId(id);
	}
	
	// for test scheduled 
	@Scheduled(fixedRate = 2000)
//	@Scheduled(cron = "${interval-in-cron}")
	@Async  
	public void calcPrice() throws InterruptedException {
		
		Thread.sleep(4000);
		
		log.info("Claculation price.."+ LocalDateTime.now());
	}
	

}
