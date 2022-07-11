package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.repositories.BookRepository;

@DataJpaTest
@ComponentScan(basePackages = { "com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.bootstrap" })
@ActiveProfiles("remote-cloud")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySqlIntegrationTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void testJpaTestSpliceTransaction() {
		long countBefore = bookRepository.count();
		// because we have included bootstrap initializing packages for execution
		assertThat(countBefore).isEqualTo(2);

	}
}
