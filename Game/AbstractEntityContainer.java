package Game;

import graphics.DrawHandler;

import java.util.ArrayList;
import java.util.Collection;

abstract class AbstractEntityContainer {
	protected ArrayList<Entity> entities;
	
	public AbstractEntityContainer() {
		entities = new ArrayList<Entity>();
	}
	
	
	protected void removeAt(int index) {
		if(entities.size() == 1) {
			entities.remove(index);
		} else {
			Entity temp = entities.get(entities.size() - 1);
			entities.set(entities.size() - 1, entities.get(index));
			entities.set(index, temp);
		}
	}
	@SuppressWarnings("unchecked")
	/**
	 * Gets all of the entities in the container
	 * @return
	 */
	public Collection<Entity> getEntities() {
		return (Collection<Entity>) entities.clone();
	}
	
	/**
	 * Updates all of the entities in the container, and removes any
	 * that are no longer alive
	 * @param elapsed time elapsed
	 */
	public void update(double elapsed) {
		for(int i = entities.size(); i >= 0; i--)
			updateEntity(entities.get(i), elapsed, i);
	}
	protected void updateEntity(Entity e, double elapsed, int position) {
		e.update(elapsed);
		if(!e.isAlive()) {
			removeAt(position);
		}
	}
	
	/**
	 * Draws all the entities in the container
	 * @param drawer
	 */
	public void draw(DrawHandler drawer) {
		for(Entity e : entities) e.draw(drawer);
	}
}
