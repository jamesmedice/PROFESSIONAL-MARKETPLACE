package com.it.gft.global.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.it.gft.global.filter.provider.FilterApiProvider;

/**
 * 
 * @author TOSS
 *
 */

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebFilter implements Filter, FilterApiProvider {

    private static final Logger logger = LoggerFactory.getLogger(WebFilter.class);

    private static final boolean CONDITION = true;

    public void init(FilterConfig filterConfig) throws ServletException {
	logger.debug(INITIATING_WEB_FILTER);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	HttpServletResponse res = (HttpServletResponse) response;
	res.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	res.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
	res.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, OPTIONS, DELETE");
	res.setHeader(ACCESS_CONTROL_MAX_AGE, "3600");
	res.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, X_REQUESTED_ORIGIN_ACCEPT_ACCESS_CONTROL_HEADERS);

	if (CONDITION == true) {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
	    String remote_addr = request.getRemoteAddr();
	    requestWrapper.addHeader("remote_addr", remote_addr);
	    chain.doFilter(requestWrapper, res);
	} else
	    ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_BAD_REQUEST);

    }

    public void destroy() {
	logger.debug(DESTROYING_WEB_FILTER);
    }

}
