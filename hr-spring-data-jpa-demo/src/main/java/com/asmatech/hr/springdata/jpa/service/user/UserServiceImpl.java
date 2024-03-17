package com.asmatech.hr.springdata.jpa.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asmatech.hr.springdata.jpa.entity.Role;
import com.asmatech.hr.springdata.jpa.entity.User;
import com.asmatech.hr.springdata.jpa.repository.UserRepository;
import com.asmatech.hr.springdata.jpa.service.role.RoleService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	@Override
	public Integer getCount() {
		return (int) userRepository.count();
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public Integer delete(Integer id) {
		try {
			userRepository.deleteById(id);
			return 1;
		}catch (Exception e) {
			e.getMessage();
			return 0;
		}		 
	}

	@Override
	@Transactional
	public void addRoleToAllUsers(String roleName) {

		Role role = roleService.findByNameEn(roleName);
		for(User user : this.findAll()) {
			user.addRole(role);
		}
	}

	
}
