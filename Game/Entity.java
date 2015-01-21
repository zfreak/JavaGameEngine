package Game;

import graphics.DrawHandler;

/**
 * A base entity in the engine. By implementing this the user can use other
 * features such as the EntityContainer. An entity is something that has some
 * behavior and is drawn onto the screen.
 * @author Daniel
 *
 */
public interface Entity {
	/**
	 * Updates the entity, performing the desired behavior
	 * @param elapsed time since last frame
	 */
	public void update(double elapsed);
	/**
	 * Draws the entity to the screen
	 * @param drawer
	 */
	public void draw(DrawHandler drawer);
	
	/**
	 * Returns whether the entity is alive.
	 * @return true if alive, false otherwise
	 */
	public boolean isAlive();
}
