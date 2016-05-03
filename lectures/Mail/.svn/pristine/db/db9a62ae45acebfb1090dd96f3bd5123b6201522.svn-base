package ca.ubc.cs.cpsc210.mail.model;

// Represents a message in the inbox

public class Message {
	
	private String msgContents; // The contents of the message
	private boolean read; // True only if message has been read

	// Constructor
	public Message(String contents) {
		msgContents = contents;
		read = false;
	}
	
	// mark the message as having been read
	// MODIFIES: this
	// EFFECTS: isRead() == true
	public void readMessage() {
		read = true;
	}
	
	// test whether the message has been read
	// EFFECTS: if message has been read 
	//          then returns true
	//           otherwise returns false
	public boolean isRead() {
		return read;
	}
	

	// return the message contents
	public String getContents() {
		return msgContents;
	}

	// The next two methods (equals and hashCode) are needed to
	// make the List of Messages work correctly. We will cover these
	// later in term.
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (this == o)
			return true;
		if (o instanceof Message) {
			Message other = (Message) o;
			if (msgContents.equals(other.getContents())
					&& read == other.isRead())
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		Boolean readValue = new Boolean(read);
		return msgContents.hashCode() + readValue.hashCode();
	}
}
