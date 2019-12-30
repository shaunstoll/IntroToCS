e(package edu.yu.intro;

import java.util.*;

public class Book {
	private final String TITLE;
	private final String SINGLE_AUTHOR;
	private final long ISBN;
	private final String BOOK_TYPE;

	public Book(final String title, final String author, final long isbn, final String type) {
		if (title == null || title == "" || author == null || author == "") {
			throw new IllegalArgumentException("Title or Author cannot be null or empty");
		}
		
		String isbnString = String.valueOf(isbn);

		if (isbnString.length() != 13) {
			throw new IllegalArgumentException("ISBN must be 13 digits");
		}

		if (!type.equals("hardcover") && !type.equals("paperback") && !type.equals("ebook")) {
			throw new IllegalArgumentException("Book type must be either hardcover, paperback, or ebook.");
		}

		TITLE = title;
		SINGLE_AUTHOR = author;	
		ISBN = isbn;
		BOOK_TYPE = type;
	}

	public String getAuthor() {return SINGLE_AUTHOR;}

	public String getTitle() {return TITLE;}

	public long getISBN13() {return ISBN;}

	public String getBookType() {return BOOK_TYPE;}

	@Override
	public boolean equals(Object that) {
		if (this == that) {return true;}
		if (that == null) {return false;}
		if (getClass() != that.getClass()) {return false;}
		
		Book otherBook = (Book) that;

		return ISBN == otherBook.ISBN;
	}

	@Override
	public int hashCode() {return Objects.hash(ISBN);}
}





