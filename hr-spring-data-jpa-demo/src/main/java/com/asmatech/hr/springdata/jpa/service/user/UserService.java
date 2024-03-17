package com.asmatech.hr.springdata.jpa.service.user;

import com.asmatech.hr.springdata.jpa.entity.User;
import com.asmatech.hr.springdata.jpa.service.HrService;


public interface UserService extends HrService<User>{

	public void addRoleToAllUsers(String roleName);
}
