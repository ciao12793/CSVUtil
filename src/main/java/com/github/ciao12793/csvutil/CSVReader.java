package com.github.ciao12793.csvutil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.github.ciao12793.csvutil.annotation.CSV;
import com.github.ciao12793.csvutil.util.ReflectionUtil;

/**
 * CSVReader.
 *
 * @author ciao
 */
public class CSVReader {

	private Path path;
	private String delimiter;

	private static final String DEFAULT_DELIMITER = ",";

	/**
	 * Constructor.
	 *
	 * @param path
	 *            resourcePath
	 */
	public CSVReader(Path path) {
		this(path, DEFAULT_DELIMITER);
	}

	/**
	 * Constructor
	 *
	 * @param path
	 *            resourcePath
	 * @param delimiter
	 *            csv delimiter
	 */
	public CSVReader(Path path, String delimiter) {
		this.path = path;
		this.delimiter = delimiter;
	}

	/**
	 * csv read and mappings.
	 *
	 * @param clazz
	 *            mapping class
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws IOException
	 */
	public <T> List<T> read(Class<T> clazz) throws ReflectiveOperationException, IOException {
		List<T> list = new ArrayList<>();

		for (String line : Files.readAllLines(path)) {
			String[] columns = line.split(delimiter, -1);
			list.add(mapping(clazz, columns));
		}

		return list;
	}

	/**
	 * create new bean and mapping csv values.
	 *
	 * @param clazz
	 *            mapping class
	 * @param columns
	 *            a csv row
	 * @return
	 * @throws ReflectiveOperationException
	 */
	private <T> T mapping(Class<T> clazz, String[] columns) throws ReflectiveOperationException {
		T bean = ReflectionUtil.getBean(clazz);

		for (Field field : clazz.getDeclaredFields()) {
			CSV annotation = field.getAnnotation(CSV.class);
			if (annotation != null) {
				String value = columns[annotation.index()];
				ReflectionUtil.set(bean, field, value);
			}
		}

		return bean;
	}
}
