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
		author1.setName("Alberto Torres");
		authorRepository.save(author1);
		
		Book book1 = new Book();
		book1.setTitle("Spring Data Rest");
		book1.setDescription("Book about Spring Data Rest");
		book1.setNumOfPages(125);
		
		book1.add(author1);
		bookRepository.save(book1);
	}
}