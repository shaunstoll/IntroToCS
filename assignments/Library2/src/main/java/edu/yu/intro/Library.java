package edu.yu.intro;

import java.util.*;

public class Library {
	private final String NAME;
	private final String ADDRESS;
	private final String PHONE_NUMBER;
	private final Library.BookCollection bookCollection = new Library.BookCollection();

	private class BookCollection {
		private final Set<Book> catelog = new HashSet<>();
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

	public boolean isTitleInHoldings(String title) {
		if (title == null || title == "") {throw new IllegalArgumentException("You must supply a non-blank title.");}
		
		boolean hasTitle = false;

		for (Book i : bookCollection.catelog) {
			if (title.equals(i.getTitle())) {
				hasTitle = true;
				break;
			}
		}

		return hasTitle;
	}

	public boolean isISBNInHoldings(long isbn13) {
		String stringISBN = String.valueOf(isbn13);

		if (stringISBN.length() != 13) {throw new IllegalArgumentException("ISBN must be 13 digits.");}
	
		boolean hasISBN = false;
		for (Book i: bookCollection.catelog) {
			if (isbn13 == i.getISBN13()) {
				hasISBN = true;
				break;
			}
		}

		return hasISBN;
	}

	public Book getBook(long isbn13) {
		String stringISBN = String.valueOf(isbn13);

		if (stringISBN.length() != 13) {throw new IllegalArgumentException("ISBN must be 13 digits.");}

		Book book = null;

		for (Book i: bookCollection.catelog) {
			if (isbn13 == i.getISBN13()) {
				book = i;
				break;
			}
		}

		return book;
	}

	public int nBooks() {return bookCollection.catelog.size();}

	@Override
	public boolean equals(Object that) {
		if (this == that) {return true;}
		if (that == null) {return false;}
		if (getClass() != that.getClass()) {return false;}
		
		Library otherLibrary = (Library) that;

		return Objects.equals(NAME, otherLibrary.NAME);
	}

	@Override
	public int hashCode() {return NAME.hashCode();}

	@Override
	public String toString() {
		return "{" + getClass() + "[name="+NAME+", address="+ ADDRESS+", phone number="+PHONE_NUMBER+"]}"; 
	}
}














