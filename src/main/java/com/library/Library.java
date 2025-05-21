package com.library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books;

	public Library() {
		books = new ArrayList<>();
	}

	public void addBook(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("Book cannot be null");
		}

		books.add(book);
	}

	public void deleteBook(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty");
		}

		if (searchBook(title) == null) {
			System.out.println("Book not found");

			return;
		}

		books.removeIf(book -> book.getTitle().equals(title));
	}

	public Book searchBook(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty");
		}

		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}

		return null;
	}

	public Book partialSearchBook(String partialTitle) {
		if (partialTitle == null || partialTitle.isEmpty()) {
			throw new IllegalArgumentException("Partial title cannot be null or empty");
		}

		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
				return book;
			}
		}

		return null;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void displayBooks() {
		System.out.println("Books in the library:");

		for (Book book : books) {
			System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicationYear());
		}
	}

	public void sortBooks() {
		books.sort((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
	}

	public void exportBooksToFile(String filePath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Book book : books) {
				writer.write(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPublicationYear());
				writer.newLine();
			}

			System.out.println("Books exported to " + filePath);
		} catch (IOException error) {
			System.err.println("Error writing to file: " + error.getMessage());
		}
	}
}
