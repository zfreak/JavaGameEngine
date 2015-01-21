package Game;

/**
 * Container that can be created and entities can be added to. Use the update 
 * and draw methods to update and draw all of the the entities. In addition to
 * updating all of the entities, the container will also check if any entities are
 * not alive and remove them from the container automatically
 * @author Daniel
 *
 */
public class EntityContainer extends AbstractEntityContainer {
	
	/**
	 * Adds the entity to the container
	 * @param entity to be added
	 */
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	/**
	 * Removes the entity from the container
	 * @param entity to be removed
	 */
	public void removeEntity(Entity entity) {
		int index = entities.indexOf(entity);
		if(index != -1) removeAt(index);
	}
}
