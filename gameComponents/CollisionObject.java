package gameComponents;

/**
 * Interface for a class that handles colliison. Used if a user wants
 * to create their own collision structures.
 * @author Daniel
 */
public interface CollisionObject {
	/**
	 * Returns whether this collision object collides with the other one
	 * @param otherObject other object to check collision with
	 * @return true if collides, false otherwise
	 */
	boolean collides(CollisionObject otherObject);
}
