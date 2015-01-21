package input;

import gameComponents.Vector2;


/**
 * Allows you to get input from the user. You have to add an input listener. The
 * methods will be called on all registered input listener whenever an event
 * happens.
 * @author Daniel Assumpcao
 * @version (a version number or a date)
 */
public class Input
{
    private static InternalInputHandler inputHandler;
    
    /***
     * DO NOT USE
     * @return DO NOT USE
     */
    public static InternalInputHandler getInternalInputHandler() {
    	return inputHandler;
    }
    /***
     * Registers an input listener to listen for events
     * @param inputListener InputListener to be added
     */
    public static void addInputListener(InputListener inputListener) {
    	inputHandler.addInputListener(inputListener);
    }
    
    /***
     * Removes an input listener
     * @param inputListener InputListener to be removed
     */
    public static void removeInputListener(InputListener inputListener) {
    	inputHandler.removeInputListener(inputListener);
    }
    
    /***
     * Gets the current mouse position
     * @return position of the mouse
     */
    public static Vector2 getMousePosition() {
    	return inputHandler.getMousePosition();
    }
}
