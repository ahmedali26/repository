package com.asmatech.hr.springdata.jpa.service.actor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.asmatech.hr.springdata.jpa.entity.Actor;
import com.asmatech.hr.springdata.jpa.service.HrService;


public interface ActorService extends HrService<Actor>{
	//Sort
//	List<Actor> filterJpa(@Param("name") String name, String colName, Boolean isAsc);
	
	//Pageable
	Page<Actor> filterJpa(@Param("name") String name, int pageNum, int pageSize, String colName, Boolean isAsc);
	
	List<Actor> filter(@Param("name") String name);
	
	
}
