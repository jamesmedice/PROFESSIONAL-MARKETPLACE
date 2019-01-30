package com.it.gft.global;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

public class ZipUtils {

	public static final String APPLICATION_ZIP = "application/zip";

	public static void setZipResponse(HttpServletResponse response, byte[] bytesFileZip, ZipEntry zipEntry, String fileName) throws Exception {
		if (bytesFileZip == null || bytesFileZip.length == 0)
			throw new Exception("The parameter bytesFileZip is empty");

		if (StringUtils.isEmpty(fileName))
			throw new Exception("The parameter fileName is null");

		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.setContentType(APPLICATION_ZIP);

		ZipOutputStream zippedOut = null;

		try {
			zippedOut = new ZipOutputStream(response.getOutputStream());
			zippedOut.putNextEntry(zipEntry);
			InputStream is = new ByteArrayInputStream(bytesFileZip);
			StreamUtils.copy(is, zippedOut);

			zippedOut.finish();
			zippedOut.flush();
			response.getOutputStream().flush();

		} catch (Exception x) {
			throw x;
		} finally {

			response.getOutputStream().close();
		}
	}

}
