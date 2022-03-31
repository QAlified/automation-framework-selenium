package config;

import java.io.File;

public class Config {
	
	private Config() {
		throw new IllegalStateException("Clase Config es una clase utilitaria, no debe ser instanciada");
	}
	
	//Project root directory
	private static final String PROJECT_DIR = System.getProperty("user.dir");
	
	//Screenshot root directory
	public static final String SCREENSHOT_PATH = PROJECT_DIR
			+ File.separator
			+ "screenshots"
			+ File.separator;
	
	//Properties Path
	public static final String PROPERTIES_PATH = PROJECT_DIR
			+ File.separator
			+ "properties"
			+ File.separator;
	
	//Files path
	public static final String FILES_PATH = PROJECT_DIR 
			+ File.separator 
			+ "files"
			+ File.separator;
	

}
