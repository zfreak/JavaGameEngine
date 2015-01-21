package Game;

import gameComponents.CollisionObject;

/**
 * An entity that can collide with other entites. Users
 * can implement this when they wish to use the CollidableEntityContainer
 * @author Daniel
 *
 */
public interface CollidableEntity extends Entity {
	/**
	 * @return Collision object of this entity
	 */
	public CollisionObject getCollisionObject();
	/**
	 * Called when this entity collides with another entity
	 * @param otherEntity entity colliding with
	 */
	public void handleCollision(CollidableEntity otherEntity);
}
