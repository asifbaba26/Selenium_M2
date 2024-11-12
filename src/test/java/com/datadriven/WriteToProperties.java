package com.datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteToProperties {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/properties/write_data.properties");

		Properties property = new Properties();

		property.load(fis);
		
		property.setProperty("subject", "selenium");
		property.put("institue", "qsipders");
		property.setProperty("trainer", "srivalli");
		
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/properties/write_data.properties");
		
		property.store(fos, "Writing into properties file");

		
	}

}
