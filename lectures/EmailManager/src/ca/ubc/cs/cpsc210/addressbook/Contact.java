package ca.ubc.cs.cpsc210.addressbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single contact in address book
 */
public class Contact extends Entry {
	private String eMailAddress;

	// constructor
	// EFFECTS: contact has given name and e-mail address is null
	public Contact(String name) {
		super(name);
		eMailAddress = null;
	}

	// constructor
	// EFFECTS: contact has given name and e-mail address
	public Contact(String name, String eMailAddress) {
		super(name);
		this.eMailAddress = eMailAddress;
	}

	// get address list
	// EFFECTS: return list containing e-mail address of this contact
	@Override
	public List<String> getAddressList() {
		List<String> al = new ArrayList<String>();
		al.add(eMailAddress);
		return al;
	}

	public String getEmailAddress() {
		return eMailAddress;
	}

	public boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128];
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
			System.out.println(letters[c]);
		}
		for (int i = 0; i < t.length(); i++) {
			int c = t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
