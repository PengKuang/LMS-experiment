package com.knf.dev.librarymanagementsystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.knf.dev.librarymanagementsystem.entity.Author;
import com.knf.dev.librarymanagementsystem.entity.Book;
import com.knf.dev.librarymanagementsystem.entity.Category;
import com.knf.dev.librarymanagementsystem.entity.Publisher;
import com.knf.dev.librarymanagementsystem.entity.Role;
import com.knf.dev.librarymanagementsystem.entity.User;
import com.knf.dev.librarymanagementsystem.repository.UserRepository;
import com.knf.dev.librarymanagementsystem.service.BookService;

@SpringBootApplication
public class Application {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate() {
		return (args) -> {

			var book = new Book("AP1287", "Dummy book", "CXEF12389", "Book description");
			book.addAuthors(new Author("Naive Robot", "dummy description"));
			book.addCategories(new Category("Dummy categary"));
			book.addPublishers(new Publisher("Dummy publisher"));
			bookService.createBook(book);

			var book1 = new Book("BP567#R", "Continues Integration and Deployment", "KCXE12389", "Description1");
			book1.addAuthors(new Author("Maxwell", "Test description1"));
			book1.addCategories(new Category("Software Engineering"));
			book1.addPublishers(new Publisher("B publisher"));
			bookService.createBook(book1);

			var book2 = new Book("GH67F#Y", "Data Structure and Algorithms", "UEWU08432", "description2");
			book2.addAuthors(new Author("Josh Lang", "Test description2"));
			book2.addCategories(new Category("Computer Science"));
			book2.addPublishers(new Publisher("A publisher"));
			bookService.createBook(book2);

			var book3 = new Book("JK82K3T", "Reinforce Learning", "AUVR38871", "description3");
			book3.addAuthors(new Author("Mattias Shneider", "Test description3"));
			book3.addCategories(new Category("Machine Learning"));
			book3.addPublishers(new Publisher("C publisher"));
			bookService.createBook(book3);

			var book4 = new Book("IOEu2FP", "Designing Design", "UVJH00932", "description4");
			book4.addAuthors(new Author("Moa Andresson", "Test description4"));
			book4.addCategories(new Category("Design"));
			book4.addPublishers(new Publisher("E publisher"));
			bookService.createBook(book4);

			var user = new User("admin", "admin", "admin@admin.in", passwordEncoder.encode("Temp123"),
					Arrays.asList(new Role("ROLE_ADMIN")));
			userRepository.save(user);

		};
	}
}
