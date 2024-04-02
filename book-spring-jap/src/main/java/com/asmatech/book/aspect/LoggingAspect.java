package com.asmatech.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.micrometer.common.util.StringUtils;

@Aspect
@Order(0)
@Component 	
public class LoggingAspect {
	
	Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	

	@Pointcut(value = "execution(* com.asmatech.book.repository..*(..))")
	public void forRepositoryLog() {}
	
	@Pointcut(value = "execution(* com.asmatech.book.service..*(..))")
	public void forServiceLog() {}
	
	@Pointcut(value = "execution(* com.asmatech.book.controller..*(..))")
	public void forControllerLog() {}
	
	
	@Pointcut(value = "forRepositoryLog() || forServiceLog() || forControllerLog()")
	public void forAll() {}
	
	
	@Before(value = "forAll()")
	public void beforAopMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		
		log.info(">>>> Exeute Method is : " + methodName);
		 String mes = ">>>>> method  "+ methodName + " args is {";
		Object args[] = joinPoint.getArgs();
		int c=0;
		for(Object arg : args) {
			c=c+1;
			if(c < args.length) {
				mes  =mes + arg + ",";
			}else {
				mes  =mes + arg;
			}
			
		}
		log.info(mes +"}");
	}
}
