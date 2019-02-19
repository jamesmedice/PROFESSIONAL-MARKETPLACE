package com.it.gft.global;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

/**
 * 
 * @author a73s
 *
 */
public class ZipUtils {

	private static final Log LOGGER = LogFactory.getLog(ZipUtils.class);

	public static final String APPLICATION_ZIP = "application/zip";

	public static void setZipResponse(HttpServletResponse response, byte[] bytesFileZip, ZipEntry zipEntry, String fileName) {
		if (bytesFileZip == null || bytesFileZip.length == 0 || StringUtils.isEmpty(fileName))
			return;

		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.setContentType(APPLICATION_ZIP);

		try {
			ZipOutputStream zippedOut = new ZipOutputStream(response.getOutputStream()); // NOSONAR
			zippedOut.putNextEntry(zipEntry);
			InputStream is = new ByteArrayInputStream(bytesFileZip);
			StreamUtils.copy(is, zippedOut);

			zippedOut.finish();
			zippedOut.flush();
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception x) {
			LOGGER.error(x);
		} finally {
		}
	}

}
