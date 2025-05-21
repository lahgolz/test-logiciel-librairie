package com.library;

public class LibraryFunctionalTest {
	public static void main(String[] args) {
		Library library = new Library();
		library.addBook(new Book("Eragon", "Christopher Paolini", 2002));
		library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
		library.addBook(new Book("1984", "George Orwell", 1949));

		library.displayBooks();

		System.out.println("\nSearching for '1984'");
		Book book = library.searchBook("1984");
		System.out.println(book != null ? "Found: " + book.getTitle() : "Not found");

		System.out.println("\nDeleting '1984'");
		library.deleteBook("1984");
		library.displayBooks();

		System.out.println("\nSearching for '1984'");
		book = library.searchBook("1984");
		System.out.println(book != null ? "Found: " + book.getTitle() : "Not found");

		System.out.println("\nPartial search for 'hobbit'");
		book = library.partialSearchBook("hobbit");
		System.out.println(book != null ? "Found: " + book.getTitle() : "Not found");

		System.out.println("\nExporting books to file");
		library.exportBooksToFile("books.txt");
	}
}
