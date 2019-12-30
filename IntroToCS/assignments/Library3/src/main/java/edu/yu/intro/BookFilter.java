package edu.yu.intro;

public class BookFilter {
	private boolean authorSwitch;
	private boolean titleSwitch;
	private boolean isbnSwitch;
	private boolean bookTypeSwitch;
	private BookFilter.Builder builder = new BookFilter.Builder();

	private BookFilter(Builder builder) {
		if (builder.author != null) {authorSwitch = true;}
		if (builder.title != null) {titleSwitch = true;}
		if (builder.isbn != 0) {isbnSwitch = true;}
		if (builder.bookType != null) {bookTypeSwitch = true;}
		this.builder = builder;
	}

	public boolean filter(Book book) {
		int count = 0;

		if (this.authorSwitch == false || this.authorSwitch == true && book.getAuthor().equals(builder.author)) {count++;}	
		
		if (this.titleSwitch == false || this.titleSwitch == true && book.getTitle().equals(builder.title)) {count++;}

		if (this.isbnSwitch == false || this.isbnSwitch == true && book.getISBN13() == builder.isbn) {count++;}

		if (this.bookTypeSwitch == false || this.bookTypeSwitch == true && book.getBookType().equals(builder.bookType)) {count++;}

		if (count == 4) {return true;}

		else {return false;}	
	}

	public static class Builder {
		private String author;
		private String title;
		private long isbn;
		private String bookType;

		public Builder() {}	

		public Builder setAuthor(String author) {
			if (author == null || author == "") {
				throw new IllegalArgumentException("Author cannot be null or empty");
			}

			this.author = author;

			return this;
		 }

		public Builder setTitle(String title) {
			if (title == null || title == "") {
				throw new IllegalArgumentException("Title cannot be null or empty");
			}

			this.title = title;

			return this;
		}

		public Builder setISBN13(long isbn13) {
			String isbnString = String.valueOf(isbn13);

			if (isbnString.length() != 13) {
				throw new IllegalArgumentException("ISBN must be 13 digits");
			}

			this.isbn = isbn13;

			return this;	
		}

		public Builder setBookType(String bookType) {
			if (!bookType.equals("hardcover") && !bookType.equals("paperback") && !bookType.equals("ebook")) {
				throw new IllegalArgumentException("Book type must be either hardcover, paperback, or ebook.");
			}

			this.bookType = bookType;

			return this;
		}

		public BookFilter build() {return new BookFilter(this);}
	}	
}