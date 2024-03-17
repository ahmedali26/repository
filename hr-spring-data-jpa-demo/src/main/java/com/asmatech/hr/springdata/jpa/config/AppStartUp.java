package com.asmatech.hr.springdata.jpa.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.asmatech.hr.springdata.jpa.entity.Role;
import com.asmatech.hr.springdata.jpa.entity.User;
import com.asmatech.hr.springdata.jpa.service.role.RoleService;
import com.asmatech.hr.springdata.jpa.service.user.UserService;

@Component
public class AppStartUp implements CommandLineRunner{
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
	@Override
	public void run(String... args) throws Exception {

		//create roles
		if(roleService.getCount().equals(0)) {
			Role role1 = new Role();
			role1.setNameAr("مدير النظام");
			role1.setNameEn("Admin");
			
			roleService.save(role1);
			
			
			Role role2 = new Role();
			role2.setNameAr("مستخدم النظام");
			role2.setNameEn("User");
			
			roleService.save(role2);
			
			Set<Role> admin = new HashSet<>();
			admin.add(role1);
			
			Set<Role> user = new HashSet<>();
			admin.add(role2);
			
			//create user
			
			User user1 = new User();
			user1.setUserName("Admin");
			user1.setPassword("admin123");
			user1.setRoles(admin);
			
			userService.save(user1);
			
			User user2 = new User();
			user2.setUserName("user");
			user2.setPassword("user123");
			user2.setRoles(user);
			
			userService.save(user2);
		
		}
		
		
	}

}
