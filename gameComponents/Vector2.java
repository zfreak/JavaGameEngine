package gameComponents;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 * A point in 2D space
 */
public class Vector2 extends Point2D.Double {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1353488090319388755L;

	/**
	 * Creates a vector2 with the specified coordinates
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Vector2(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a vector2 given a vector's magnitude and angle. Assuming its from the origin
	 * @param magnitude magnitude of the vector
	 * @param angle angle of the vector
	 * @return new vector2
	 */
	public static Vector2 createFromVector(double magnitude, double angle) {
		return new Vector2(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
	}
	
	/**
	 * Adds two vector2s together, returning a new one
	 * @param other Vector2 to add to this one
	 * @return the result of the addition
	 */
	public Vector2 add(Vector2 other) {
		return new Vector2(x+other.x, y + other.y);
	}
	
	/**
	 * Sets the location of this vector2 to the specified x and y coordinates
	 * @param x x value
	 * @param y y value
	 */
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Subtracts two vector2s, and returns a new one as the result
	 * @param other Vector2 to subtract
	 * @return the result
	 */
	public Vector2 subtract(Vector2 other) {
		return new Vector2(x - other.x, y - other.y);
	}
	
	/**
	 * Converts the Vector2 to a point
	 * @return the Point object
	 */
	public Point convertToPoint() {
		return new Point((int)Math.round(x), (int)Math.round(y));
	}
	
	/**
	 * Multiplies the Vector by the value
	 * @param factor factor to multiply by
	 * @return a new vector2
	 */
	public Vector2 multiply(double factor) {
		return new Vector2(x * factor, y * factor);
	}
	
	/**
	 * Gets the distance between this vector and another
	 * @param other other Vector2 to compare distance
	 * @return distance between them
	 */
	public double distanceBetween(Vector2 other) {
		return Math.sqrt(Math.pow(x-other.x, 2) + Math.pow(y-other.y,2));
	}
	
	/**
	 * Gets the x value of the vector
	 * @return x value
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the y value of the vector
	 * @return y value
	 */
	public double getY() {
		return y;
	}

	public Object clone() {
		return new Vector2(x,y);
	}
	
	/**
	 * Gets the magnitude of this vector2, as compared to the origin
	 * @return the magnitude
	 */
	public double getMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	/**
	 * Gets the angle between this vector and another vector
	 * @param otherVector the other vector
	 * @return the angle in radians
	 */
	public double getAngleBetween(Vector2 otherVector) {
		return Math.atan2(otherVector.y - this.y, otherVector.x - this.x);
	}
	
	/**
	 * Clamps the magnitude of the vector as compared to the origin
	 * @param magnitude magnitude to be clamped to
	 * @return new Vector2 with clamped magnitude
	 */
	public Vector2 clamp(double magnitude) {
		if(this.getMagnitude() < magnitude) {
			return new Vector2(this.x, this.y);
		} else {
			double angle = Math.atan2(this.y, this.x);
			return new Vector2(magnitude, angle);
		}
	}
	
}
