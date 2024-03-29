package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class help retrieve environmental and file configuration to use in application
 * It is a singleton so it can only be instantiated once and used through-out the application life-cycle.
 * @author damzxyno
 *
 */
public class Configuration {
	private static final String DEFAULT_CONFIG_FILE = "config.properties";
	private static final Logger logger = Logger.getLogger(Configuration.class.getName());
	private static Properties properties;
	private static Configuration CONFIGURATION;
	private Configuration() {}
	
	public static Configuration getInstance() {
		if (CONFIGURATION == null) {
			CONFIGURATION = new Configuration();
		}
		return CONFIGURATION;
	}
	
	/**
	 * This method help load the properties from the default configuration file.
	 */
	private void loadProperties() {
		properties = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(DEFAULT_CONFIG_FILE)) {
		    if (input == null) {
		        return;
		    }
		    properties.load(input);
		} catch (IOException ex) {
		    ex.printStackTrace();
		    return;
		}
	}

	/**
	 * This method helps retrieve properties value using the property name
	 * @param propertyName
	 * @return
	 */
	public String getPropertyByName(String propertyName) {
		if(properties == null) {
			loadProperties();
		}
		var property = properties.getProperty(propertyName);
		if (property == null) {
			logger.log(Level.SEVERE, String.format("Property with name '%s' not found.", propertyName));
		}
		return property.trim();
	}
}
