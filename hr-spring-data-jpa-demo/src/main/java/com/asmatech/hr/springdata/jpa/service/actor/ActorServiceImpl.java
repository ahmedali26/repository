package com.asmatech.hr.springdata.jpa.service.actor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.asmatech.hr.springdata.jpa.entity.Actor;
import com.asmatech.hr.springdata.jpa.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	ActorRepository actorRepository;
	
	@Override
	public Integer getCount() {
		return (int) actorRepository.count();
	}

	@Override
	public Optional<Actor> findById(Integer id) {
		return actorRepository.findById(id);
	}

	@Override
	public List<Actor> findAll() {
		return (List<Actor>) actorRepository.findAll();
	}

	@Override
	public Actor save(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public Integer delete(Integer id) {
		try {
			actorRepository.deleteById(id);
			return 1;
		}catch (Exception e) {
			e.getMessage();
			return 0;
		}		 
	}

	@Override
	public List<Actor> filter(String name) {
		return actorRepository.filter(name);
	}

	@Override
	public Page<Actor> filterJpa(String name, int pageNum, int pageSize, String colName, Boolean isAsc) {
		if(name.isEmpty() || name.isBlank() || name==null) {
			name=null;
		}
		
		Pageable page = PageRequest.of(pageNum, pageSize, Sort.by(isAsc ? Direction.ASC : Direction.DESC , colName)); 
		return actorRepository.filterJpa(name, page);
	}

	
}
