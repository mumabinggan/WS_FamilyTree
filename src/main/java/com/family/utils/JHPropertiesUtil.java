package com.mmall.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Slf4j
public class JHPropertiesUtil {

	private static Properties props;

	static {
		String fileName = "mmall.properties";
		props = new Properties();
		try {
			props.load(new InputStreamReader(JHPropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
		} catch (IOException e) {
			log.error("配置文件读取异常", e);
		}
	}

	public static String getProperty(String key) {
		return getProperty(key, null);
	}

	public static String getProperty(String key, String defaultValue) {
		String value = props.getProperty(key, defaultValue);
		if (JHStringUtils.isBlank(value)) {
			value = defaultValue;
		}
		return value.trim();
	}
}


