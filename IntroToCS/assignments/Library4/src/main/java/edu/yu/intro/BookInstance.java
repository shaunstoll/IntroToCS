package edu.yu.intro;

import java.util.UUID;

public class BookInstance {
	private final UUID uuid;
	private final Book book;
	private LoanState loanState;
	private Patron patron;

	public BookInstance(Book book) {
		uuid = UUID.randomUUID();
		this.book = book;
		loanState = LoanState.AVAILABLE;
	}

	public String getId() {return uuid.toString();}

	Book getBook() {
		return this.book;
	}

	Patron getPatron() {
		Patron patron = null;

		// if on loan or reserve, return patron

		return patron;
	}

	LoanState getLoanState() {
		return this.loanState;
	}

	public void borrow(Patron patron) throws OnLoanException {
		if (patron == null) {throw new IllegalArgumentException("Patron cannot be null.");}
		if (loanState.equals(LoanState.BORROWED) || (!this.patron.equals(patron) && this.patron != null)) {throw new OnLoanException("This book is not available.");}
		this.loanState = LoanState.BORROWED;
		this.patron = patron;
	}

	public void reserve(Patron patron) {
		if (patron == null) {throw new IllegalArgumentException("Patron cannot be null.");}
		if (getLoanState().equals(LoanState.BORROWED) || (!this.patron.equals(patron) && this.patron != null)) {throw new IllegalStateException("This book is not available.");}
		this.loanState = LoanState.ON_RESERVE;
		this.patron = patron;
	}

	public void returnInstance(final Patron patron) throws NotOnLoanException {
		if (patron == null) {throw new IllegalArgumentException("Patron cannot be null.");}
		if (!getLoanState().equals(LoanState.BORROWED)) {throw new OnLoanException("This book is not on loan.");}
		if (!this.patron.equals(patron) && this.patron != null) {throw new IllegalStateException("This book is on loan to a different patron.")}
		this.loanState = LoanState.AVAILABLE;
		this.patron = null;
	}
}