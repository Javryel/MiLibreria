package com.javryel.github.miLibreriaDemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javryel.github.miLibreriaDemo.models.Libro;

@Service
public interface ILibroService {
	
	public void saveLibro(Libro libro);

	public List<Libro> getAllLibros();

	public Libro getLibroById(Integer id);

	public void updateLibro(Libro libro);

	public void deleteLibro(Integer id);
}
