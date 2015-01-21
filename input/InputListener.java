package input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/***
 * Interface that needs to be implemented in order for a class to 
 * listen to input
 * @author Daniel
 *
 */
public interface InputListener {
	/***
	 * Called when a key is pressed
	 * @param arg
	 */
	void keyPressed(KeyEvent arg);
	/***
	 * Called when a key is released
	 * @param arg
	 */
	void keyReleased(KeyEvent arg);
	/***
	 * Called when one of the buttons on the mouse is pressed
	 * @param e
	 */
	void mousePressed(MouseEvent e);
	/***
	 * Called when one of the buttons on the mouse is released
	 * @param e
	 */
	void mouseReleased(MouseEvent e);
}
