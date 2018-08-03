package com.it.gft.global.aspect.provider;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * @author a73s
 *
 */
@Component
@Aspect
public class CompanyAspect extends BaseServiceAspect {

	@AfterReturning(pointcut = "execution(* com.it.gft.global.service.CompanyService.findById(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("Servcice Method: " + joinPoint.getSignature().getName());
		LOGGER.info("Result: " + result);
	}

	@Around("execution(* com.it.gft.global.service.CompanyService.findById(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("Servcice Method: " + joinPoint.getSignature().getName());
		LOGGER.info("Servcice Arguments: " + Arrays.toString(joinPoint.getArgs()));

		joinPoint.proceed();
	}
}
