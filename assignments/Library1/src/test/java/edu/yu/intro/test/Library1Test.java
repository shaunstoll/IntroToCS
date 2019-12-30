package edu.yu.intro.test;

import edu.yu.intro.Book;
import edu.yu.intro.Library;
import org.junit.*;
import static org.junit.Assert.*;

public class Library1Test {
	
	@Test(expected = IllegalArgumentException.class) public void illegalArgumentsBook() {
		Book book1 = new Book("Moby Dick", "Johnson", 1L, "paperback");
		Book book2 = new Book("Moby Dick", "Johnson", 1000000000001L, "napkin");
		Book book3 = new Book("Moby Dick", "", 1000000000001L, "hardcover");
		Book book4 = new Book(null, "Johnson", 1000000000001L, "hardcover");

	}

	@Test public void bookTest() {
		Book book = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
	}

	@Test(expected = IllegalArgumentException.class) public void duplicateLibraryNamesTest() {
		Library library1 = new Library("NYC", "Amsterdam Ave", "929-264");
		Library library2 = new Library("NYC", "Columbus Ave", "502-787");
	}

	@Test(expected = IllegalArgumentException.class) public void nullLibraryName() {
		Library library1 = new Library("Denver", "Amsterdam Ave", null);
	}

	@Test public void addBookTest() {
		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Library library = new Library("Toronto", "Rodeo", "905");
		library.add(book1);
		library.add(book2);
	}

	@Test(expected = IllegalArgumentException.class) public void isbnDuplicates() {
		Library library = new Library("Pittsburgh", "Rodeo", "905");
		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Moby Dick", "Johnson", 1000000000001L, "hardcover");
		library.add(book1);
		library.add(book2);
	}

	@Test public void isTitleInHoldingsTest() {
		Library library = new Library("San Diego", "Rodeo", "905");
		Book book = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		library.add(book);
		assertEquals(true, library.isTitleInHoldings("Moby Dick"));
	}

	@Test public void isISBNInHoldingsTest() {
		Library library = new Library("LA", "Rodeo", "905");
		Book book = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		library.add(book);
		assertEquals(true, library.isISBNInHoldings(1000000000001L));
		assertEquals(false, library.isISBNInHoldings(1000000000002L));
	}

	@Test public void getBookTest() {
		Library library = new Library("Oakland", "Rodeo", "905");
		Book book = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		library.add(book);
		assertEquals(book, library.getBook(1000000000001L));
		assertEquals(null, library.getBook(1000000000002L));
	}

	@Test public void nBooksTest() {
		Library library = new Library("San Fransisco", "Rodeo", "905");
		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		library.add(book1);
		library.add(book2);
		assertEquals(2, library.nBooks());
	}
}








