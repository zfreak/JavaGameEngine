package Game;

import gameComponents.CollisionObject;
import gameComponents.CollisionRectangle;
import gameComponents.Vector2;

/**
 * An entity that has a position, velocity, and also has a size so that it
 * can check for collision. Users should override the update method to add additional functionality
 * and the draw method to actually draw the entity. They also should implement the handleCollision
 * method so that the entity will properly handle collisions with other entities
 * @author Daniel
 *
 */
public abstract class PhysicsEntity extends AbstractEntity implements CollidableEntity{
	private Vector2 position;
	private int width;
	private int height;
	/**
	 * @return Position of the entity
	 */
	public Vector2 getPosition() {
		return new Vector2(position.x, position.y);
	}

	/**
	 * Sets the position of the entity
	 * @param position new position
	 */
	public void setPosition(Vector2 position) {
		this.position = new Vector2(position.x, position.y);
	}


	private Vector2 velocity;
	
	/**
	 * @return velocity of the entity
	 */
	public Vector2 getVelocity() {
		return new Vector2(velocity.x, velocity.y);
	}

	/**
	 * Sets the velocity of the entity
	 * @param velocity new velocity
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = new Vector2(velocity.x, velocity.y);
	}

	/**
	 * Constructor for physics entity. Any subclasses will need to 
	 * supply the values for this constructor
	 * @param position of the entity
	 * @param width of the entity
	 * @param height of the entity
	 */
	public PhysicsEntity(Vector2 position, int width, int height) {
		this.position = position;
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	/**
	 * Updates the entity, allowing it to perform its behavior
	 */
	public void update (double elapsed) 
	{
		position = position.add(velocity.multiply(elapsed));
	}
	
	/**
	 * Gets the collision object that this entity represents
	 */
	public CollisionObject getCollisionObject() {
		return new CollisionRectangle(position, width, height);
	
	}
	/**
	 * Called when this entity collides with another entity
	 * @param otherEntity entity colliding with
	 */
	public abstract void handleCollision(CollidableEntity otherEntity);
	
	
}
