package com.asmatech.book.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component 	
public class MajormentAspect {
	
	Logger log = LoggerFactory.getLogger(MajormentAspect.class);
	
	@Around(value = "execution(* com.asmatech.book.base..*(..))")
	public Object logTime(ProceedingJoinPoint  joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder("KPI:");
		sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
				.append("\twithArgs: ").append("(");
		sb.append("\ttook: ");
		Object returnValue = joinPoint.proceed();
		log.info(sb.append(System.currentTimeMillis() - startTime).append(" ms.").toString());
		
		return returnValue;
	}


}
