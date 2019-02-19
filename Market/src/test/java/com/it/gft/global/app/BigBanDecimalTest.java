package com.it.gft.global.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BigBanDecimalTest {

	protected Log LOG = LogFactory.getLog(getClass());

	@Test
	public void roundingTest() {

		List<BigDecimal> bigDecimals = Arrays.asList(new BigDecimal("12"), new BigDecimal("2"), new BigDecimal("1"), new BigDecimal("1"));

		int sum = bigDecimals.stream().mapToInt(BigDecimal::intValue).sum();

		LOG.info("total: " + sum);

		BigDecimal total = new BigDecimal(0);

		for (final BigDecimal bd : bigDecimals) {
			BigDecimal round = roundBigDecimal(bd, BigDecimal.valueOf(sum), RoundingMode.HALF_UP);
			total = total.add(round);
			LOG.info(round.toPlainString());
		}

		LOG.info(total + "\n\n");
		total = new BigDecimal(0);

		for (final BigDecimal bd : bigDecimals) {
			BigDecimal round = roundBigDecimal(bd, BigDecimal.valueOf(sum), RoundingMode.HALF_EVEN);
			total = total.add(round);
			LOG.info(round.toPlainString());
		}

		LOG.info(total + "\n\n");
		total = new BigDecimal(0);

		for (final BigDecimal bd : bigDecimals) {
			BigDecimal round = roundBigDecimal(bd, BigDecimal.valueOf(sum), RoundingMode.HALF_DOWN);
			total = total.add(round);
			LOG.info(round.toPlainString());
		}

		LOG.info(total + "\n\n");
		total = new BigDecimal(0);

		for (final BigDecimal bd : bigDecimals) {
			BigDecimal round = roundBigDecimal(bd, BigDecimal.valueOf(sum), RoundingMode.CEILING);
			total = total.add(round);
			LOG.info(round.toPlainString());
		}

		LOG.info(total);

	}

	public static BigDecimal roundBigDecimal(final BigDecimal input, final BigDecimal total, RoundingMode rounding) {
		return input.setScale(6).divide(total, rounding).multiply(BigDecimal.valueOf(100));
	}
}
