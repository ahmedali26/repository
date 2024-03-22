package com.asmatech.book.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseService<T extends BaseEntity, ID extends Number> {
	
	@Autowired
	BaseRepository<T, ID> baseRepository;
	

	public Long getCount() {
		return baseRepository.count();
	}

	public Optional<T> findById(ID id) {
		return baseRepository.findById(id);
	}

	public List<T> findAll() {
		return baseRepository.findAll();
	}


	public T save(T t) {
		return baseRepository.save(t);
	}


	public ID delete(ID id) {
		baseRepository.deleteById(id);
		return id;
	}
	
}
