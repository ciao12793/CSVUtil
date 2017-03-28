package com.github.ciao12793.csvutil.dto;

import com.github.ciao12793.csvutil.annotation.CSV;

public class Book {

	@CSV(index = 0)
	public String isbn;

	@CSV(index = 1)
	public String bookName;

	@CSV(index = 2)
	public String author;

	@Override
	public String toString() {
		return String.format("isbn:%s, name:%s, author:%s", isbn, bookName, author);
	}
}
