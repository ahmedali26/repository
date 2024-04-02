package com.asmatech.book.validate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IPAdderssImpl.class})
public @interface IPAdderss {
	
	/**
	 * @return the error message template
	 */
	String message() default "{validation.ip.Pattern.message}";

	/**
	 * @return the groups the constraint belongs to
	 */
	Class<?>[] groups() default { };

	/**
	 * @return the payload associated to the constraint
	 */
	Class<? extends Payload>[] payload() default { };
	
	
	
	

}
