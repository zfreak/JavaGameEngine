package Game;

import graphics.DrawHandler;

/**
 * An abstract entity that handles some basic entity functionality
 * If users want to create their own entities, they will likely want to extend others
 * which have more functionality such as the physics entity.
 * @author Daniel
 *
 */
public abstract class AbstractEntity implements Entity{
	private boolean alive = true;
	
	/***
	 * Returns whether the entity is alive
	 */
	public boolean isAlive() { return alive;}
	/**
	 * Sets whether the entity is alive or not
	 * @param value true if entity is alive, false otherwise
	 */
	public void setAlive(boolean value) { alive = value;}
	/**
	 * Updates the entity, allowing it to perform its behavior
	 */
	public abstract void update(double elapsed);
	/**
	 * Draws the entity
	 */
	public abstract void draw(DrawHandler drawer);
}
