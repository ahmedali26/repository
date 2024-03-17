package com.asmatech.hr.springdata.jpa.service.role;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asmatech.hr.springdata.jpa.entity.Role;
import com.asmatech.hr.springdata.jpa.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Integer getCount() {
		return (int) roleRepository.count();
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Integer delete(Integer id) {
		try {
			roleRepository.deleteById(id);
			return 1;
		}catch (Exception e) {
			e.getMessage();
			return 0;
		}		 
	}

	@Override
	public Role findByNameEn(String name) {
		
		return roleRepository.findByNameEn(name);
	}

	
}
