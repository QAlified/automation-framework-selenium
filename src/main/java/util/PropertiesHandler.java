package util;

import java.io.FileInputStream;
import java.util.Properties;

import config.Config;
import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;

public class PropertiesHandler {
	
	private String CONFIGURATION_DIR = Config.PROPERTIES_PATH;
	private Properties p;

	public void loadProperties(String propFileName) throws NoSuchPropertyFileException {
		try {

			FileInputStream f = new FileInputStream(CONFIGURATION_DIR + propFileName + ".properties");
			p = new Properties();
			p.load(f);
			f.close();

		} catch (Exception e) {
			throw new NoSuchPropertyFileException(propFileName);
		}

	}

	public String getProp(String propName) throws MissingPropertyException {
		String value = (String) p.get(propName);
		if (value == null)
			throw new MissingPropertyException(propName);

		return value;

	}
	
	

}
