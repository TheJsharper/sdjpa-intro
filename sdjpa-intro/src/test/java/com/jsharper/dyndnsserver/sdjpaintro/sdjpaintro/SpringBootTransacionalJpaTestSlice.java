package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;

import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.domain.Book;
import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.repositories.BookRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = { "com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.bootstrap" })

public class SpringBootTransacionalJpaTestSlice {

	@Autowired
	private BookRepository bookRepository;

	// @Rollback(value = false) that will work but by using commit better
	@Commit
	@Order(1)
	@Test
	void testJpaTestSplice() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(2);
		bookRepository.save(new Book("My Book ", "1245588", "Self-test"));

		long countAfter = bookRepository.count();

		assertThat(countBefore).isLessThan(countAfter);

	}

	@Order(2)
	@Test
	void testJpaTestSpliceTransaction() {
		long countBefore = bookRepository.count();
		// because we have included bootstrap initializing packages for execution
		assertThat(countBefore).isEqualTo(3);

	}
}
