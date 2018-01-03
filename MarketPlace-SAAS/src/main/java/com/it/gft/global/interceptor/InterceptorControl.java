package com.it.gft.global.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorControl extends HandlerInterceptorAdapter implements HandlerInterceptor {

    public static final String REQ_ATTR_START_TIME = "startTime";

    public static final String REQ_ATTR_TRACE_ID = "traceId";

}
