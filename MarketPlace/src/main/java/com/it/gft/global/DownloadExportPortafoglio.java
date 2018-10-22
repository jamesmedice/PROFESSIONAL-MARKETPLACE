package com.it.gft.global;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadExportPortafoglio extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Do get.
	 * 
	 * @param req
	 *            the req
	 * @param resp
	 *            the resp
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Author: U0E8327 - Date: Oct 2, 2009
		performTask(req, resp);
	}

	/**
	 * Do post.
	 * 
	 * @param req
	 *            the req
	 * @param resp
	 *            the resp
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Author: U0E8327 - Date: Oct 2, 2009
		performTask(req, resp);
	}

	/**
	 * Method execute.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 */
	public void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			String id = request.getParameter("id");
			String idSto = request.getParameter("idSto");
			ServletOutputStream out = response.getOutputStream();

			if (idSto != null) {

				byte[] exp = null;
				byte[] expSto = null;

				File fileUnzip = getFileUnzip(exp);
				File fileUnzipSto = getFileUnzip(expSto);

				File fileCsv = File.createTempFile("export", ".csv");

				/*
				 * MG - 9/10/2018 - SONAR: Close this "FileOutputStream" "fin"
				 * in a "finally" clause. Close this "FileReader" "finSto" in a
				 * "finally" clause. Close this "FileOutputStream" "fosOut" in a
				 * "finally" clause.
				 */
				FileReader fin = null;
				FileReader finSto = null;
				FileOutputStream fosOut = null;
				BufferedReader br = null;
				BufferedReader brSto = null;
				PrintStream psOut = null;

				try {

					fin = new FileReader(fileUnzip);
					br = new BufferedReader(fin);
					String line;

					finSto = new FileReader(fileUnzipSto);
					brSto = new BufferedReader(finSto);
					String lineSto;
					int i = 0;
					int iSto = 0;
					fosOut = new FileOutputStream(fileCsv);
					psOut = new PrintStream(fosOut);

					while ((line = br.readLine()) != null) {
						StringBuffer sb = new StringBuffer();
						sb.append(line);
						sb.append((char) 13);
						sb.append((char) 10);
						psOut.print(sb);
						if (i++ > 8) {

							while ((lineSto = brSto.readLine()) != null) {
								if (iSto++ > 9) {
									StringBuffer sbSto = new StringBuffer();
									sbSto.append(lineSto);
									sbSto.append((char) 13);
									sbSto.append((char) 10);
									psOut.print(sbSto);
								}
							}

						}
					}
				} finally {

					if (br != null)
						br.close();

					if (brSto != null)
						brSto.close();

					if (fin != null)
						fin.close();

					if (finSto != null)
						finSto.close();

					if (fosOut != null)
						fosOut.close();

					if (psOut != null)
						psOut.close();

					if (psOut != null)
						psOut.close();

				}

				fileUnzip.delete();
				fileUnzipSto.delete();

				byte[] bytesFromFile = getBytesFromFile(fileCsv);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ZipOutputStream zos = new ZipOutputStream(baos);
				zos.putNextEntry(new ZipEntry("export-dati.csv"));
				zos.write(bytesFromFile);
				zos.closeEntry();
				zos.finish();
				fileCsv.delete();

				File fileZIP = File.createTempFile("export-dati", ".zip");

				/*
				 * MG - 9/10/2018 - SONAR: Close this "FileOutputStream" "fos"
				 * in a "finally" clause.
				 */
				FileOutputStream fos = null;

				try {

					fos = new FileOutputStream(fileZIP);
					fos.write(baos.toByteArray());

				} finally {

					fos.close();

				}
				bytesFromFile = getBytesFromFile(fileZIP);

				response.setContentLength(bytesFromFile.length);
				response.setContentType("application/zip");
				// response.setHeader("cache-control", "no-cache");

				response.setHeader("Content-Disposition", "filename=\"ExportDati.zip\"");

				out.write(bytesFromFile);
				out.flush();
				out.close();

				fileZIP.delete();

			} else {

				// response.setContentLength(dto.getFileExport().length);
				response.setContentType("application/zip");
				// response.setHeader("cache-control", "no-cache");

				response.setHeader("Content-Disposition", "filename=\"ExportDati.zip\"");

				// out.write(dto.getFileExport());
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * Gets the bytes from file.
	 * 
	 * @param file
	 *            the file
	 * @return the bytes from file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;

		/*
		 * MG - 31/08/2017 - SONAR: Close this "FileOutputStream" "is" in a
		 * "finally" clause.
		 */
		try {
			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
			if (offset < bytes.length) {
				throw new IOException("Could not completely read file " + file.getName());
			}
		} finally {
			is.close();
		}

		return bytes;
	}

	/**
	 * Gets the file unzip.
	 * 
	 * @param exp
	 *            the exp
	 * @return the file unzip
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	private File getFileUnzip(byte[] exp) throws IOException, FileNotFoundException {
		File tmpZipExp = File.createTempFile("unzipfile", ".csv");
		ByteArrayInputStream bais = new ByteArrayInputStream(exp);
		ZipInputStream zis = new ZipInputStream(bais);
		ZipEntry ze = zis.getNextEntry();
		byte[] buffer = new byte[1024];
		while (ze != null) {

			String fileName = ze.getName();

			// System.out.println("file unzip : " +
			// tmpZipExp.getAbsoluteFile());

			FileOutputStream fos = new FileOutputStream(tmpZipExp);

			int len;

			/*
			 * MG - 31/08/2017 - SONAR: Close this "FileOutputStream" "fos" in a
			 * "finally" clause.
			 */
			try {
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
			} finally {
				fos.close();
			}
			ze = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();
		return tmpZipExp;
	}

}
