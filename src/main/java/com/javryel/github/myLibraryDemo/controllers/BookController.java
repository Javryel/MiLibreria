package com.javryel.github.myLibraryDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javryel.github.myLibraryDemo.models.Book;
import com.javryel.github.myLibraryDemo.services.BookServiceImpl;

@RestController
@RequestMapping("/book")

public class BookController {

	@Autowired
	private BookServiceImpl bookService;

	@GetMapping("")
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> allBooks = bookService.getAllBooks();

		if (!allBooks.isEmpty()) {
			return new ResponseEntity<>(allBooks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

	}

	@PostMapping("/create")
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		try {
		bookService.saveBook(book);
			return new ResponseEntity<String>("Libro creado", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{book_id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer book_id) {
		Book book = bookService.getBookById(book_id);
		if (book != null) {
			return new ResponseEntity<>(book, HttpStatus.OK);
		} else {

			return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {

		try {
			bookService.updateBook(book);
			Book bookUpdate = bookService.getBookById(book.getBookId());

			if (bookUpdate != null) {
				return new ResponseEntity<>(bookUpdate, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{book_id}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer book_id) {

		try {
			Book book = bookService.getBookById(book_id);
			if (book != null) {
				bookService.deleteBook(book_id);
				return new ResponseEntity<>("Libro eliminado", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No existe libro", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
