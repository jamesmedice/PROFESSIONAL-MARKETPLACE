package com.it.gft.global.aspect.provider;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CompanyPointcutDefinition {

    @Pointcut("within(com.it.gft.global.service..*)")
    public void serviceLayer() {
    }

}
