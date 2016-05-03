package ca.ubc.cs.cpsc210.mail.model;

// Represents the inbox of a mail program. The inbox maintains 
// 0 or more messages with the newest message always added as the
// message at the 1st index of the inbox.

// HINT: You need to choose a representation for the data (e.g., define some fields...)

import java.util.ArrayList;

public class Inbox {


	ArrayList<Message> messages;


	private int numberofMessages;
	private int unreadmessages;

	// Constructor
	// EFFECTS: numberOfMessages() == 0
	public Inbox() {
numberofMessages=0;
		unreadmessages=0;
	}

	// Add a message into the inbox
	// REQUIRES: m is not a message in the inbox
	// MODIFIES: this
	// EFFECTS: getNthMessage(1) returns m
	public void addMessage(Message m) {
messages.add(m);	}

	// Are there unread messages in the inbox?
	// EFFECTS: returns number of unread messages 
	//    Note: return value is >= 0 but <= numberOfMessages()
	public int unreadMessages() {
		int n=0;
		for(Message e:messages){
			if(e.isRead()==false){
				n+=1;
			}

		}
		return n;
	}

	// Return the nth message in the inbox where the 1st message is
	// the newest message
	// REQUIRES: i > 0 AND numberOfMessages() >= i
	// EFFECTS: returns the ith message in the inbox
	public Message getNthMessage(int i) {
		// YOU WILL NEED TO COMPLETE THIS METHOD
		return messages.get(i); // Just to make the class compile until you complete the
						// method. Note it currently does not meet the
						// specification!
	}

	// Remove the message from the inbox
	// MODIFIES: may modify this
	// EFFECTS: if m was found in the inbox,
	// then m is no longer in inbox and there is one less message in the inbox
	// else number of messages in the inbox is unchanged
	public void removeMessage(Message m) {
		for(Message e:messages){
			if(e==m){
				messages.remove(e);
			}

		}
	}

	// How many messages are in the inbox?
	// EFFECTS: returns a value >= 0 that represents the number of
	// messages in the inbox
	public int numberOfMessages() {
		// YOU WILL NEED TO COMPLETE THIS METHOD
		return numberofMessages; // Just to make the class compile until you complete the
					// method. Note it currently does not meet the
					// specification!
	}

	// Is the given message in the inbox?
	// EFFECTS: returns true if m is in inbox otherwise returns false
	public boolean contains(Message m) {
		for (Message e : messages) {
			if (e == m) {
				return true;
			}
			 // Return false until you complete this method
		}
		return false;
	}

}
