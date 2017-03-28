package com.github.ciao12793.csvutil.util;

import java.lang.reflect.Field;

/**
 * ReflectionUtil.
 *
 * @author ciao
 */
public class ReflectionUtil {

	/**
	 * create new instance.
	 *
	 * @param clazz
	 * @return
	 * @throws ReflectiveOperationException
	 */
	public static <T> T getBean(Class<T> clazz) throws ReflectiveOperationException {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw e;
		}
	}

	public static <T> void set(T bean, Field f, Object value) throws IllegalArgumentException, IllegalAccessException {
		f.setAccessible(true);

		switch (f.getType().getName()) {
		case "int":
			f.setInt(bean, Integer.valueOf((String) value));
			break;
		default:
			f.set(bean, value);
		}
	}

	private ReflectionUtil() {
	}
}
