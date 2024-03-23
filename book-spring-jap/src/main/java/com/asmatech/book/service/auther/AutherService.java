package com.asmatech.book.service.auther;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmatech.book.base.BaseService;
import com.asmatech.book.entity.Auther;
import com.asmatech.book.repository.AutherRepository;
import com.asmatech.book.repository.specification.AutherSpecification;
import com.asmatech.book.search.AutherSearch;

@Service
public class AutherService extends BaseService<Auther, Long>{

	@Autowired
	AutherRepository autherRepository;
	
	public List<Auther> findByAutherSpecification(AutherSearch search){
		AutherSpecification spec = new AutherSpecification(search);
		return autherRepository.findAll(spec);
	}
  

}
