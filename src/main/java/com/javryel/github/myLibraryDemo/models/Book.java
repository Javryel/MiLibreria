package com.javryel.github.myLibraryDemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private Long isbn;
	
	private String title;
	private Integer year;
	private Integer amount;
	private Integer amountLend;
	private Integer amountRemaining;
	private Boolean register; 
}
