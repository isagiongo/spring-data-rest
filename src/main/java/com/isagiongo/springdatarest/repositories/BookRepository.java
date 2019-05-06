package com.isagiongo.springdatarest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.isagiongo.springdatarest.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
