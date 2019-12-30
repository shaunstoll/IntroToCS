package edu.yu.intro;

import java.util.*;

public class Library {
	private final String NAME;
	private final String ADDRESS;
	private final String PHONE_NUMBER;
	private List<Book> catelog = new ArrayList<>();
	private static List<String> libraryNames = new ArrayList<>();
	
	public Library(final String name, final String address, final String phoneNumber) {

		if (name == null || name == "" || address == null || address == "" || phoneNumber == null || phoneNumber == "") {
			throw new IllegalArgumentException("Name, Address, or Phone Number cannot be null or empty");
		}
		if (libraryNames.contains(name)) {throw new IllegalArgumentException("This library name already exists.");}
		
		libraryNames.add(name);

		NAME = name;
		ADDRESS = address;
		PHONE_NUMBER = phoneNumber;
	}

	public String getName() {return NAME;}

	public String getAddress() {return ADDRESS;}

	public String getPhoneNumber() {return PHONE_NUMBER;}

	public void add(Book b) {
		
		for (Book i: catelog) {
			if (b.getISBN13() == i.getISBN13() && (!b.getAuthor().equals(i.getAuthor()) || 
				!b.getTitle().equals(i.getTitle()) || !b.getBookType().equals(i.getBookType()))) {
				throw new IllegalArgumentException("Book info doesn't correspond to holdings.");
			}
		}

		catelog.add(b);
	}

	public boolean isTitleInHoldings(String title) {
		if (title == null || title == "") {throw new IllegalArgumentException("You must supply a non-blank title.");}
		
		boolean hasTitle = false;

		for (Book i: catelog) {
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
		for (Book i: catelog) {
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

		for (Book i: catelog) {
			if (isbn13 == i.getISBN13()) {
				book = i;
				break;
			}
		}

		return book;
	}

	public int nBooks() {return catelog.size();}
}














