package ru.arkuzmin.diplom.optimization.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	
	private static final String PROP_BCMAP_FNAME = "props/bcmap.properties";
	
	private static Properties PROP_BCMAP = new Properties();
	
	static {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(PROP_BCMAP_FNAME);
			PROP_BCMAP.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		for (Object key : PROP_BCMAP.keySet()) {
			System.out.println(key + " : " + PROP_BCMAP.getProperty((String)key));
		}
	}
}
