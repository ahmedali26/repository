package com.asmatech.hr.springdata.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asmatech.hr.springdata.jpa.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

//	//sorting
//	@Query(value = "select a from Actor a where :name is null or (firstName like :name or lastName like :name)")
//	List<Actor> filterJpa(@Param("name") String name, Sort sort);
	
	//Pageable
	@Query(value = "select a from Actor a where :name is null or (firstName like :name or lastName like :name)")
	Page<Actor> filterJpa(@Param("name") String name, Pageable pageable);
	
	
	
	@Query(value = "select * from hr.actors where first_name like '%' :name '%'  or last_name like '%' :name '%' order by first_name asc", 
			nativeQuery = true)
	List<Actor> filter(@Param("name") String name);
	
}
