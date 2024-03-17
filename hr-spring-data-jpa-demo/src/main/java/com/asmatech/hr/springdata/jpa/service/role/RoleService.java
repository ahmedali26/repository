package com.asmatech.hr.springdata.jpa.service.role;

import com.asmatech.hr.springdata.jpa.entity.Role;
import com.asmatech.hr.springdata.jpa.service.HrService;


public interface RoleService extends HrService<Role>{

	public Role findByNameEn(String name);
	
}
