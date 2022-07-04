package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.domain.Book;
import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.repositories.BookRepository;

@DataJpaTest
public class SpringBootJpaTestSlice {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void testJpaTestSplice() {
		long countBefore = bookRepository.count();

		bookRepository.save(new Book("My Book ", "1245588", "Self-test"));

		long countAfter = bookRepository.count();

		assertThat(countBefore).isLessThan(countAfter);

	}
}
