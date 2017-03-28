package com.github.ciao12793.csvutil.dto;

import com.github.ciao12793.csvutil.annotation.CSV;

public class Human {

	@CSV(index = 0)
	public String name;

	@CSV(index = 1)
	public int age;

	@Override
	public String toString() {
		return String.format("name:%s, age:%d", name, age);
	}
}
