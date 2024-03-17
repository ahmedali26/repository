package com.asmatech.hr.springdata.jpa.service;

import java.util.List;
import java.util.Optional;


public interface HrService<T> {

	public Integer getCount();
	
	public Optional<T> findById(Integer id);
	
	public List<T> findAll();
	
	public T save(T t);
	
	public Integer delete(Integer id);
	
}
