package com.asmatech.book.service.auther;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.asmatech.book.base.BaseService;
import com.asmatech.book.entity.Auther;
import com.asmatech.book.error.DaplicateRecordException;
import com.asmatech.book.repository.AutherRepository;
import com.asmatech.book.repository.specification.AutherSpecification;
import com.asmatech.book.search.AutherSearch;

@Service
public class AutherService extends BaseService<Auther, Long> {

	Logger log = LoggerFactory.getLogger(AutherService.class);
	
	@Autowired
	AutherRepository autherRepository;
	
	@Autowired
	MessageSource messageSource;

	public List<Auther> findByAutherSpecification(AutherSearch search) {
		AutherSpecification spec = new AutherSpecification(search);
		return autherRepository.findAll(spec);
	}

	public Optional<Auther> findByEmail(String email) {
		return autherRepository.findByEmail(email);
	}

	@Override
	public Auther insert(Auther t) {
		
		Optional<Auther> auther = findByEmail(t.getEmail());
		log.info("Auther name is {} and email is {}", t.getName(), t.getEmail());
		if(auther.isPresent()) {
			String[] msgParams= {t.getEmail()};
			String message = messageSource.getMessage("validation.emailAnExsit.message", msgParams, LocaleContextHolder.getLocale());
			log.error(message);
			throw new DaplicateRecordException(message);
		}else {
		return super.insert(t);
		}
	
	}
}
