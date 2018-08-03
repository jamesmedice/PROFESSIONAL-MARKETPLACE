package com.it.gft.global.aspect.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public abstract class BaseServiceAspect {

    Log LOGGING = LogFactory.getLog(this.getClass());

    @Before("com.it.gft.global.aspect.provider.CompanyPointcutDefinition.serviceLayer()")
    public void MethodExecution(JoinPoint joinPoint) {
	LOGGING.info("Executing Servcice: " + joinPoint.getSignature().getName());
    }

    @After("com.it.gft.global.aspect.provider.CompanyPointcutDefinition.serviceLayer()")
    public void logAfter(JoinPoint joinPoint) {
	LOGGING.info("Finished Execution Servcice Method: " + joinPoint.getSignature().getName());
    }
}
