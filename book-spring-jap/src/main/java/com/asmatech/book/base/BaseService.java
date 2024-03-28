package com.asmatech.book.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.asmatech.book.error.RecordNotFoundException;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseService<T extends BaseEntity, ID extends Number> {
	
	@Autowired
	BaseRepository<T, ID> baseRepository;
	
	@Autowired
	MessageSource messageSource;

	public Long getCount() {
		return baseRepository.count();
	}

	public T findById(ID id) {
		Optional<T> entity = baseRepository.findById(id);
		if(entity.isPresent()) {
			return entity.get();
		}else {
			String[] msgParams= {id.toString()};
			String message = messageSource.getMessage("validation.recordNotFound.message", msgParams, LocaleContextHolder.getLocale());
			throw new RecordNotFoundException(message);
		}
	}
	

	public List<T> findAll() {
		return baseRepository.findAll();
	}


	public T insert(T t) {
		return baseRepository.save(t);
	}

	public T update(T t) {
		return baseRepository.save(t);
	}


	public ID delete(ID id) {
		baseRepository.deleteById(id);
		return id;
	}
	
}
