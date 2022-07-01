package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.domain.Book;
import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.repositories.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final BookRepository bookRepository;

	public DataInitializer(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		var bookDDD = new Book("Domain Driven Design", "123", "RandomHaouse");

		var savedDDD = this.bookRepository.save(bookDDD);

		System.out.println("ID" + bookDDD.getId());
		System.out.println("ID" + savedDDD.getId());

		var bookSIA = new Book("Spring in Action", "12888883", "O'Realy");

		var savedSIA = this.bookRepository.save(bookSIA);
		System.out.println("ID" + savedSIA.getId());

		this.bookRepository.findAll().forEach(b -> System.out.print(b));

	}

}
