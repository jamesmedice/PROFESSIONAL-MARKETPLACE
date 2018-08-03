package com.it.gft.global.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.gft.global.filter.provider.API_RESPONSE;
import com.it.gft.global.filter.provider.ApiProvider;

/**
 * 
 * @author TOSS
 *
 */
@RestController
@RequestMapping("/surifire")
public class WebApi extends ApiProvider {

	private static final Logger logger = LoggerFactory.getLogger(WebApi.class);

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> doSomething(@RequestHeader(name = "remote_addr") String remoteAddress) {

		logger.debug(THE_REMOTE_ADDRESS_ADDED_BY_WEB_FILER_IS, remoteAddress);

		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<Object>(API_RESPONSE.SUCCESS.name(), HttpStatus.OK);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
