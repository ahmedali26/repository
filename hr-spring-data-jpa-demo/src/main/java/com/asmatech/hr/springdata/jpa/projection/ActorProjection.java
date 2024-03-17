package com.asmatech.hr.springdata.jpa.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ActorProjection {

	Integer getId();
	
	String getFirstName();
	
	String getLastName();
	
	@Value("#{target.firstName+ '  ' + target.lastName}")
	String getFullName();
}
