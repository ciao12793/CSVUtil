package com.github.ciao12793.csvutil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.github.ciao12793.csvutil.dto.Book;
import com.github.ciao12793.csvutil.dto.Human;

public class CSVReaderTest {

	private static final String basePath = "src/test/resources/csv/in";

	@Test
	public void testHuman() throws ReflectiveOperationException, IOException {

		Path path = Paths.get(basePath, "human.csv");
		Class<Human> clazz = Human.class;

		List<Human> list = new CSVReader(path).read(clazz);

		assertThat(list.size(), is(3));
		assertThat(list.get(0).name, is("taro"));
		assertThat(list.get(0).age, is(27));

		assertThat(list.get(1).name, is("nick"));
		assertThat(list.get(1).age, is(38));

		assertThat(list.get(2).name, is("ken"));
		assertThat(list.get(2).age, is(33));
	}

	@Test
	public void testBook() throws ReflectiveOperationException, IOException {
		Path path = Paths.get(basePath, "book.csv");
		Class<Book> clazz = Book.class;

		List<Book> list = new CSVReader(path).read(clazz);

		assertThat(list.size(), is(3));
		assertThat(list.get(0).isbn, is("978-4-7973-8679-0"));
		assertThat(list.get(0).bookName, is("Unity5の教科書"));
		assertThat(list.get(0).author, is("北村 愛実"));

		assertThat(list.get(1).isbn, is("978-4-7981-4247-0"));
		assertThat(list.get(1).bookName, is("Spring徹底入門 Spring FrameworkによるJavaアプリケーション開発"));
		assertThat(list.get(1).author, is("株式会社NTTデータ"));

		assertThat(list.get(2).isbn, is("978-4-87311-758-4"));
		assertThat(list.get(2).bookName, is("ゼロから作るDeep Learning――Pythonで学ぶディープラーニングの理論と実装"));
		assertThat(list.get(2).author, is("斎藤 康毅"));
	}

}
