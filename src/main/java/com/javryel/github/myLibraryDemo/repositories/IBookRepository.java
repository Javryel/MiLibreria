package com.javryel.github.myLibraryDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javryel.github.myLibraryDemo.models.Book;



public interface IBookRepository extends JpaRepository<Book, Integer>{

}
