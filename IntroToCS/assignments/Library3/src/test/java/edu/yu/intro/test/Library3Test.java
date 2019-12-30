package edu.yu.intro.test;

import edu.yu.intro.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class Library3Test {

	@Test public void nBooksTest() {
		Library library = Driver.run();
		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		library.add(book1);
		assertEquals(4, library.nBooks());
	}
	
	@Test public void onLoanTest() {
		Library library = new Library("NYC", "Amsterdam Ave", "929-264-9897");

		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Bone", "J. Smith", 1200000000001L, "ebook");
		Book book3 = new Book("LOFTR", "JRR Tolkins", 2000000000001L, "hardcover");
		
		library.add(book1);
		library.add(book2);
		library.add(book3);
		
		Patron patron1 = new Patron("Shaun", "Stoll", "Rodeo Drive");
		Patron patron2 = new Patron("Joshua", "StDeutsch", "Croft Terrace");
		
		library.add(patron1);
		library.add(patron2);

		library.borrow(patron1, book1);
		library.borrow(patron1, book1);
		library.borrow(patron1, book2);
		library.borrow(patron2, book1);

		Collection<Book> onLoan1 = library.onLoan(patron1);
		Collection<Book> onLoan2 = library.onLoan(patron2);

		assertEquals(3, onLoan1.size());
		assertEquals(1, onLoan2.size());
	}

	@Test public void filterTest() {
		BookFilter.Builder builder = new BookFilter.Builder();

		Library library = new Library("NYC", "Amsterdam Ave", "929-264-9897");

		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Bone", "Johnson", 1200000000001L, "ebook");
		Book book3 = new Book("LOFTR", "JRR Tolkins", 2000000000001L, "hardcover");
		
		library.add(book1);
		library.add(book2);
		library.add(book3);
		
		BookFilter bookFilter = builder.build();
		Collection<Book> filteredCatelog = library.search(bookFilter);
		assertEquals(3, filteredCatelog.size());

		bookFilter = builder.setAuthor("Johnson").build();
		filteredCatelog = library.search(bookFilter);
		assertEquals(2, filteredCatelog.size());
	}	
}