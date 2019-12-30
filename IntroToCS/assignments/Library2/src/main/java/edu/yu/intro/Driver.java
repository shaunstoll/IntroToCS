package edu.yu.intro;

public class Driver {
	
	public static void run() {
		Patrons.Singleton.clear();
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
		Patrons.Singleton.add(patron1);
		Patrons.Singleton.add(patron2);
	}
}