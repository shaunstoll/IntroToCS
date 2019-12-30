package edu.yu.intro;

import java.util.*;

public enum Patrons {
	Singleton;
	Map<String, Patron> uuidToPatron = new HashMap<>();
	Set<Patron> patrons = new HashSet<>();

	public void add(Patron patron) {
		if (patron == null) {throw new IllegalArgumentException("Patron cannot be null");}
		uuidToPatron.put(patron.getId(), patron);
		patrons.add(patron);
	}

	public void clear() {
		uuidToPatron.clear();
		patrons.clear();
	}

	public Patron get(String uuid) {
		if (uuid == null) {throw new IllegalArgumentException("uuid cannot be null.");}
		
		Patron patron = null;

		if (uuidToPatron.containsKey(uuid) == true) {return uuidToPatron.get(uuid);}

		return patron;
	}

	public int nPatrons() {return uuidToPatron.size();}

	public Set<Patron> byLastNamePrefix(final String prefix) {
		if (prefix == null) {throw new IllegalArgumentException("Prefix cannot be null");}

		Set<Patron> filteredPatrons = new HashSet<>();

		for (Patron patron : patrons) {
			if (patron.getLastName().startsWith(prefix)) {
				filteredPatrons.add(patron);
			}
		}

		return filteredPatrons;
	}
}








