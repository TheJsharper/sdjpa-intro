package com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jsharper.dyndnsserver.sdjpaintro.sdjpaintro.domain.Book;

public interface BookRepositoryMongoDB extends MongoRepository<Book, Long> {

}
