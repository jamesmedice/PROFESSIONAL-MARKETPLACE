package com.it.gft.global.aspect.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public abstract class BaseServiceAspect {

    Log LOGGER = LogFactory.getLog(this.getClass());

    @Before("com.it.gft.global.aspect.provider.CompanyPointcutDefinition.serviceLayer()")
    public void MethodExecution(JoinPoint joinPoint) {
	LOGGER.info("Executing Servcice: " + joinPoint.getSignature().getName());
    }

    @After("com.it.gft.global.aspect.provider.CompanyPointcutDefinition.serviceLayer()")
    public void logAfter(JoinPoint joinPoint) {
	LOGGER.info("Finished Execution Servcice Method: " + joinPoint.getSignature().getName());
    }
}
