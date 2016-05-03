package ca.ubc.cpsc210.remotecontrol;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * A remote control.
 */
public class RemoteControl implements Iterable<Channel> {


	private List<Channel> channelList;

	// Add private variables to provide an implementation
	// of the remote here.
	
	/*
	 * Constructs remote control with no channels.
	 */
	public RemoteControl() {
		// Add initialization of private variables here.
		channelList=new ArrayList<Channel>();
		
	}
	
	/*
	 * Adds a channel with the given channel number 
	 * to the remote control.  Maintains the order 
	 * in which channels were added.  Does not allow
	 * duplicate channels.
	 */
	public void addChannel(int numberOfChannel) {
		Channel c=new Channel(numberOfChannel);
		if (!channelList.contains(c))
			channelList.add(c);
		// Add a new channel to the remote here.
	}

	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@Override
	public Iterator iterator() {
		return channelList.iterator();
	}

	// Add any additional methods needed below...
	

}

