package com.github.ciao12793.csvutil.exception;

/**
 * CSVUtilException.
 *
 * @author ciao
 */
public class CSVUtilException extends RuntimeException {

	public CSVUtilException() {
		super();
	}

	public CSVUtilException(String name) {
		super(name);
	}

	public CSVUtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public CSVUtilException(Throwable cause) {
		super(cause);
	}

}
