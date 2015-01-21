package Game;

/**
 * Container that can contain all the collidable entities. Should be used to update and draw
 * all of the collidable entities in the game. In addition to the functionality of the EntityContainer
 * class, CollidableEntityContainer will automatically check for collision between the entities and call
 * the handle collision function if they do collide
 * @author Daniel
 *
 */
public class CollidableEntityContainer extends AbstractEntityContainer {
	public class EntityContainer extends AbstractEntityContainer {
		
		/**
		 * Adds the entity to the container
		 * @param entity to be added
		 */
		public void addEntity(CollidableEntity entity) {
			entities.add(entity);
		}
		
		/**
		 * Removes the entity from the container
		 * @param entity to be removed
		 */
		public void removeEntity(CollidableEntity entity) {
			int index = entities.indexOf(entity);
			if(index != -1) removeAt(index);
		}
		
		protected void updateEntity(Entity e, double elapsed, int position) {
			super.updateEntity(e, elapsed, position);
			CollidableEntity cEntity = (CollidableEntity)e;
			for(Entity other : this.getEntities()) {
				CollidableEntity otherCollidable = (CollidableEntity)other;
				if(otherCollidable != cEntity && cEntity.getCollisionObject().collides(otherCollidable.getCollisionObject())) {
					cEntity.handleCollision(otherCollidable);
					otherCollidable.handleCollision(cEntity);
				}
			}
		}
	}
}
