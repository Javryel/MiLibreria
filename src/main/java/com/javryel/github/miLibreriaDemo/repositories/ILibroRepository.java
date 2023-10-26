package com.javryel.github.miLibreriaDemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javryel.github.miLibreriaDemo.models.Libro;



public interface ILibroRepository extends JpaRepository<Libro, Integer>{

}
