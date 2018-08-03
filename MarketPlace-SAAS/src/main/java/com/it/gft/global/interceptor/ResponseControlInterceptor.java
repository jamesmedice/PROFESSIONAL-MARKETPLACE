package com.it.gft.global.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 
 * @author TOSS
 *
 */
@ControllerAdvice
public class ResponseControlInterceptor implements ResponseBodyAdvice<Message> {

	private static final String TIMER_STAMP = "TIMER";

	@Autowired
	HttpServletRequest request;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		if (returnType == null || returnType.getNestedParameterType() == null || returnType.getNestedParameterType().getSuperclass() == null)
			return false;
		return returnType.getNestedParameterType().getSuperclass().equals(Message.class);
	}

	@Override
	public Message<?> beforeBodyWrite(Message body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest req,
			ServerHttpResponse response) {

		if (request != null && request.getAttribute(InterceptorControl.REQ_ATTR_START_TIME) != null) {
			final long start = (Long) request.getAttribute(InterceptorControl.REQ_ATTR_TRACE_ID);
			body.getHeaders().put(TIMER_STAMP, System.currentTimeMillis() - start);
		}

		return body;
	}

}
