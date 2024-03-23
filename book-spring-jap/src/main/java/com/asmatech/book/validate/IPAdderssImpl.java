package com.asmatech.book.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IPAdderssImpl implements ConstraintValidator<IPAdderss, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value.isBlank() || value.isEmpty() || value==null) {
			return true;
		}
		
		Pattern pattern = Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
		Matcher matcher = pattern.matcher(value);
		try{
			if(!matcher.matches()){
				return false;
			}else{
				for(int i=1; i<=4; i++){
					int octet = Integer.valueOf(matcher.group(i));
					if(octet > 255){
						return false;
					}
				}
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}

}
