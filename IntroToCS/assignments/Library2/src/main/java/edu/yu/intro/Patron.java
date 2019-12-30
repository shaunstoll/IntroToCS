package edu.yu.intro;

import java.util.*;

public class Patron {
	private final UUID uuid;
	private final String FIRST_NAME;
	private final String LAST_NAME;
	private final String ADDRESS;

	public Patron(final String firstName, final String lastName, final String address) {
		if (firstName == null || firstName == "" ||
			lastName == null || lastName == "" ||
			address == null || address == "") {
			throw new IllegalArgumentException("first name, last name, or address cannot be null or blank.");
	}
		FIRST_NAME = firstName;
		LAST_NAME = lastName;
		ADDRESS = address;
		uuid = UUID.randomUUID();
	}

	public String getFirstName() {return FIRST_NAME;}

	public String getLastName() {return LAST_NAME;}

	public String getAddress() {return ADDRESS;}

	public String getId() {return uuid.toString();}

	@Override
	public boolean equals(Object that) {
		if (this == that) {return true;}
		if (that == null) {return false;}
		if (getClass() != that.getClass()) {return false;}
		
		Patron otherPatron = (Patron) that;

		return Objects.equals(uuid, otherPatron.uuid);
	}

	@Override
	public int hashCode() {return uuid.hashCode();}
}