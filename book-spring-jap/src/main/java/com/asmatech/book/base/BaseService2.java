package com.asmatech.book.base;

import java.util.List;
import java.util.Optional;


public interface BaseService2<T> {

	public Long getCount();
	
	public Optional<T> findById(Long id);
	
	public List<T> findAll();
	
	public T save(T t);
	
	public Integer delete(Long id);
	
}
