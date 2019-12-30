package edu.yu.intro.test;

import edu.yu.intro.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class Library2Test {

	@Test public void filterTest() {
		Driver.run();
		Set<Patron> patrons = Patrons.Singleton.byLastNamePrefix("");
		assertEquals(2, patrons.size());
		Patrons.Singleton.clear();
	}

	@Test public void sameISBNTest(){
		Library library = new Library("NYC", "Amsterdam Ave", "929-264-9897");
		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Bone", "J. Smith", 1200000000001L, "ebook");
		Book book3 = new Book("LOFTR", "JRR Tolkins", 2000000000001L, "hardcover");
		Book book4 = new Book("LOFTR", "JRR Tolkins", 2000000000001L, "paperback");
		library.add(book1);
		library.add(book2);
		library.add(book3);
		library.add(book4);
		Patron patron1 = new Patron("Shaun", "Stoll", "Rodeo Drive");
		Patron patron2 = new Patron("Joshua", "StDeutsch", "Croft Terrace");
		Patron patron3 = new Patron("Joshua", "StDeutsch", "Croft Terrace");

		assertEquals(3, library.nBooks());

		Patrons.Singleton.add(patron1);
		Patrons.Singleton.add(patron2);
		Patrons.Singleton.add(patron3);

		assertEquals(3, Patrons.Singleton.nPatrons());
	}

	@Test public void getPatronViaUUID() {
		Patron patron = new Patron("Jonathan", "Stoll", "Rodeo Drive");
		Patrons.Singleton.add(patron);
		assertEquals(patron, Patrons.Singleton.get(patron.getId()));
	}

	@Test public void nBooksTest() {
		Library library = new Library("NYC", "Amsterdam Ave", "929-264-9897");
		Book book1 = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		Book book2 = new Book("Bone", "J. Smith", 1000000000001L, "ebook");
		Book book3 = new Book("Bone", "J. Smith", 1200000000001L, "ebook");
		library.add(book1);
		library.add(book2);
		library.add(book3);
		assertEquals(2, library.nBooks());
	}

	@Test
	public void testEqualHashcodes() {
		String name = "name";
		String address = "address";
		String phoneNumber = "9";
		final Library library1 = new Library(name, address, phoneNumber);
		final Library library2 = new Library(name, address+"b", phoneNumber+"1");
		assertEquals(library1, library2);

		final Library library3 = new Library(name, address, phoneNumber);
		assertEquals(library1, library3);

		assertEquals(library1.hashCode(), library2.hashCode());
		assertEquals(library1.hashCode(), library3.hashCode());
	}

	@Test
	public void testNotEqual () {
		String name = "name";
		String address = "address";
		String phoneNumber = "9";
		final Library library1 = new Library(name, address, phoneNumber);
		final String differentName = name+"a";
		final Library library2 = new Library(differentName, address , phoneNumber);
		assertNotEquals("Match on unequal Libraries", library1, library2);
		assertNotEquals("Match on unequal hashCode", library1.hashCode(), library2.hashCode() );
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

	@Test public void staticBookCollectioTest() {
		Library library1 = new Library("Scranton", "Rodeo", "905");
		Library library2 = new Library("Oakland", "Rodeo", "905");
		Book book = new Book("Moby Dick", "Johnson", 1000000000001L, "paperback");
		library1.add(book);
		assertEquals(0, library2.nBooks());
	}
}







