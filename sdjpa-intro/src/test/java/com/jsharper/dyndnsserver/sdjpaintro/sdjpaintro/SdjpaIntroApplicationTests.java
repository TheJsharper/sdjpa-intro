package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.repositories.BookRepository;

@SpringBootTest
class SdjpaIntroApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void bookCountTest() {

		long count = bookRepository.count();
		assertThat(count).isGreaterThan(0);

	}

}
