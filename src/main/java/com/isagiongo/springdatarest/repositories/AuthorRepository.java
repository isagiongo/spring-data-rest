package com.isagiongo.springdatarest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.isagiongo.springdatarest.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
