import java.awt.event.KeyEvent;

/**
 * A spaceship in 2D space that moves within a rectangle whose bounds are defined by
 * -250 <= x <= 250, -500 <= y <= 500
 * 
 * @author CPSC 210 Instructor
 * @version Version 1.1 July 2015
 */
public class Spaceship {
	// The x,y coordinates of the spaceship as integers
	private int x;
	private int y;

	
	/**
	 * Construct a new spaceship object and place it at the center of the rectangle
	 */
	public Spaceship() {
		x = 0; // This statement sets the x field of the object to the value 0
		y = 0; // This statement sets the y field of the object to the value 0
	}
	
	/**
	 * Move the spaceship within the rectangle by the specified increments in the x and y directions.
     * Move as far as possible without ever going outside of the rectangle.
	 * @param dx The increment for the x direction, can be a negative value to move left
	 * @param dy The increment for the y direction, can be a negative value to move up
	 */
	public void move(int dx, int dy) {
    this.x+=dx;
		this.y+=dy;
		int leftboundary=-250;
		short rightboundary=250;
		short topboundary=-500;
		short bottomboundary=500;
		if (rightboundary<=this.x){
			x=250;}
		if (leftboundary>=x) x=-250;
		if (bottomboundary<=y) y=500;
		if (topboundary>=y){ y=-500;}
	}


public void keytyped(char c){

}




	/*
	 * Return the current x coordinate value of the spaceship
	 */
	public int getX() {
		return x;
	}
	
	/*
	 * Return the current y coordinate value of the spaceship
	 */
	public int getY() { 
		return y;
	}

}
