package edu.yu.intro;

public class Driver {
	
	public static Library run() {
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

		return library;
	}
}