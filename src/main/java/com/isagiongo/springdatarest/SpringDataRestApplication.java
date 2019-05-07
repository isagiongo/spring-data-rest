package com.isagiongo.springdatarest;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isagiongo.springdatarest.models.Author;
import com.isagiongo.springdatarest.models.Book;
import com.isagiongo.springdatarest.repositories.AuthorRepository;
import com.isagiongo.springdatarest.repositories.BookRepository;

@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@PostConstruct
    @Transactional
	public void onLoad() {
		Author author1 = new Author();
		author1.setName("Eduardo Spinelli");
		authorRepository.save(author1);
		
		Author author2 = new Author();
		author2.setName("Karine Cardoso");
		authorRepository.save(author2);
		
		Book book1 = new Book();
		book1.setTitle("Spring Data Rest");
		book1.setDescription("Como usar Spring data rest em seu projeto");
		book1.setNumOfPages(125);
		
		book1.add(author1);
		book1.add(author2);
		bookRepository.save(book1);
		
		Author author3 = new Author();
		author3.setName("Guilherme Palma");
		authorRepository.save(author3);
		
		Author author4 = new Author();
		author4.setName("João");
		authorRepository.save(author4);
		
		Book book2 = new Book();
		book2.setTitle("Introdução prática ao JPA");
		book2.setDescription("Entenda a diferença entre a JPA e o Hibernate");
		book2.setNumOfPages(125);
		
		book2.add(author3);
		book2.add(author4);
		bookRepository.save(book2);
		
	}
}