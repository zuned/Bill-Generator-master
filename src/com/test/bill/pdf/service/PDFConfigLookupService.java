package com.test.bill.pdf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.test.bill.pdf.service.PDFConfigLookupService;

public class PDFConfigLookupService {

	public static byte[] getTemplateByLocation(String templateLocation) throws IOException {
		InputStream inputStream = getDocument(templateLocation);
		if (inputStream != null && inputStream.available() > 0) {
			return IOUtils.toByteArray(inputStream);
		}
		return null;
	}
	
	private static InputStream getDocument(String documentPath) throws RuntimeException {
		File file = new File(documentPath);
		if (file.exists()) {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				System.out.println("Error reading the template.");
			}
		}
		return null;
	}

}
