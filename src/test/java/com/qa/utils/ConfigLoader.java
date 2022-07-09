package com.qa.utils;

import static com.qa.constants.FrameworkConstants.DIRECTORY_ENV_CONFIG;
import static com.qa.constants.FrameworkConstants.ENV_CONFIG_PROD;
import static com.qa.constants.FrameworkConstants.ENV_CONFIG_QA;
import static com.qa.constants.FrameworkConstants.ENV_CONFIG_STG;
import static com.qa.constants.FrameworkConstants.PARAMETER_ENV;

import java.util.Properties;

import com.qa.enums.EnvType;

public class ConfigLoader {

	private static final String BASE_URL = "baseUrl";
	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";


	// private final Properties properties;
	private Properties properties;

	private static ConfigLoader configLoader;

	private ConfigLoader() {

		/**
		 * Setting the Environment Parameter here.
		 * 
		 * By default, QA will be taken
		 */
		// PARAMETER_ENV = "env";
		String env = System.getProperty(PARAMETER_ENV, String.valueOf(EnvType.QA));

		switch (EnvType.valueOf(env)) {

		case QA: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_QA);
			break;
		}
		case STG: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_STG);
			break;
		}
		case PROD: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_PROD);
			break;
		}
		default:
			throw new IllegalStateException("INVALID ENV: " + env);
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getBaseUrl() {
		return getPropertyValue(BASE_URL);
	}

	public String getSendEmailToUsers() {
		return getPropertyValue(SEND_EMAIL_TO_USERS);
	}
	
	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}
	
	
}
