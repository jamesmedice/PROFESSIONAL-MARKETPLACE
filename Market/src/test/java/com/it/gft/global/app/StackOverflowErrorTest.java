package com.it.gft.global.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author u0i2747
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StackOverflowErrorTest {

	protected Log LOG = LogFactory.getLog(getClass());

	private static final String NUMMER = "NUMMER: ";

	@Test(expected = StackOverflowError.class)
	public void stackOverflowErrorTest() {
		recursiveLogInfo(1);
	}

	public void recursiveLogInfo(int nummer) {
		LOG.info(NUMMER + nummer);

		if (nummer == 0)
			return;
		else
			recursiveLogInfo(++nummer);
	}
}
