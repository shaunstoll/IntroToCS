package edu.yu.intro;

import java.util.*;

public class Library {
	private final String NAME;
	private final String ADDRESS;
	private final String PHONE_NUMBER;
	private final Library.BookCollection bookCollection = new Library.BookCollection();
	private final Library.Patrons patrons = new Library.Patrons();

	private static class BookCollection {
		List<Book> catelog = new ArrayList<>();
	}

	private static class Patrons {
		Map<String, Patron> uuidToPatron = new HashMap<>();
		Set<Patron> patronSet = new HashSet<>();
		Map<Patron, List<Book>> patronToRentals = new HashMap<>();
	}
	
	public Library(final String name, final String address, final String phoneNumber) {

		if (name == null || name == "" || address == null || address == "" || phoneNumber == null || phoneNumber == "") {
			throw new IllegalArgumentException("Name, Address, or Phone Number cannot be null or empty");
		}
		
		NAME = name;
		ADDRESS = address;
		PHONE_NUMBER = phoneNumber;
	}

	public String getName() {return NAME;}

	public String getAddress() {return ADDRESS;}

	public String getPhoneNumber() {return PHONE_NUMBER;}

	public void add(Book b) {bookCollection.catelog.add(b);}

	public int nBooks() {return bookCollection.catelog.size();}

	public void borrow(Patron patron, Book book) {
		if (!patrons.patronSet.contains(patron)) {
			throw new IllegalArgumentException("Patron is not a member of this library.");
		}

		if (!bookCollection.catelog.contains(book)) {
			throw new IllegalArgumentException("Book is not in library's holdings.");
		}

		List<Book> rentals = patrons.patronToRentals.get(patron);
		rentals.add(book);

		patrons.patronToRentals.put(patron, rentals);
	}

	public Collection<Book> onLoan(Patron patron) {
		if (!patrons.patronSet.contains(patron)) {throw new IllegalArgumentException("Patron is not a member of this library.");}

		return patrons.patronToRentals.get(patron);
	}

	public Collection<Book> search(BookFilter filter) {
		Set<Book> filteredCatelog = new HashSet<>();

		for (Book book : bookCollection.catelog) {
			if (filter.filter(book) == true) {filteredCatelog.add(book);}
		}

		return filteredCatelog;
	}

	public void add(Patron patron) {
		if (patron == null) {throw new IllegalArgumentException("Patron cannot be null");}
			patrons.uuidToPatron.put(patron.getId(), patron);
			patrons.patronSet.add(patron);
			List<Book> rentals = new ArrayList<>();
			patrons.patronToRentals.put(patron, rentals);
		}

	public Patron get(String uuid) {
		if (uuid == null || uuid == "") {throw new IllegalArgumentException("uuid cannot be null or empty.");}
		
		Patron patron = null;

		if (patrons.uuidToPatron.containsKey(uuid) == true) {return patrons.uuidToPatron.get(uuid);}

		return patron;
	}

	public int nPatrons() {return patrons.uuidToPatron.size();}

	public Set<Patron> byLastNamePrefix(final String prefix) {
		if (prefix == null) {throw new IllegalArgumentException("Prefix cannot be null");}

		Set<Patron> filteredPatrons = new HashSet<>();

		for (Patron i : patrons.patronSet) {
			if (i.getLastName().startsWith(prefix)) {
				filteredPatrons.add(i);
			}
		}

		return filteredPatrons;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {return true;}
		if (that == null) {return false;}
		if (getClass() != that.getClass()) {return false;}
		
		Library otherLibrary = (Library) that;

		return Objects.equals(NAME, otherLibrary.NAME);
	}

	@Override
	public int hashCode() {return Objects.hash(NAME);}

	@Override
	public String toString() {
		return "{" + getClass() + "[name="+NAME+", address="+ ADDRESS+", phone number="+PHONE_NUMBER+"]}"; 
	}
}














