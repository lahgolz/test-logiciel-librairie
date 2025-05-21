package com.library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
	private Library library;

	@BeforeEach
	public void setUp() {
		library = new Library();
	}

	@Test
	public void testAddBook() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);

		assertEquals(1, library.getBooks().size());
		assertEquals(book, library.getBooks().get(0));
	}

	@Test
	public void testAddNullBook() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.addBook(null);
		});
	}

	@Test
	public void testDeleteBook() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);
		library.deleteBook("Test Book");

		assertEquals(0, library.getBooks().size());
	}

	@Test
	public void testDeleteBookNotFound() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);
		library.deleteBook("This Book Does Not Exist");

		assertEquals(1, library.getBooks().size());
	}

	@Test
	public void testDeleteBookEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.deleteBook("");
		});
	}

	@Test
	public void testSearchBook() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);

		assertEquals(book, library.searchBook("Test Book"));
	}

	@Test
	public void testSearchBookEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.searchBook("");
		});
	}

	@Test
	public void testSearchBookNotFound() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);

		assertNull(library.searchBook("This Book Does Not Exist"));
	}

	@Test
	public void testPartialSearchBook() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);

		assertEquals(book, library.partialSearchBook("test"));
	}

	@Test
	public void testPartialSearchBookEmptyTitle() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.partialSearchBook("");
		});
	}

	@Test
	public void testPartialSearchBookNotFound() {
		Book book = new Book("Test Book", "Test Author", 2025);

		library.addBook(book);

		assertNull(library.partialSearchBook("nothing"));
	}

	@Test
	public void testSortBooks() {
		Book book1 = new Book("B Book", "Author B", 2020);
		Book book2 = new Book("A Book", "Author A", 2021);
		Book book3 = new Book("C Book", "Author C", 2019);

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);

		library.sortBooks();

		assertEquals(book2, library.getBooks().get(0));
		assertEquals(book1, library.getBooks().get(1));
		assertEquals(book3, library.getBooks().get(2));
	}
}
