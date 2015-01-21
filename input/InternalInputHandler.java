package input;

import gameComponents.Vector2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/**
 * DO NOT USE. FOR INTERNAL USE
 * @author Daniel
 */
public class InternalInputHandler implements MouseMotionListener, MouseListener, KeyListener
{
    private int x;
    private int y;
    private ArrayList<InputListener> listeners;
    protected InternalInputHandler() {
    	listeners = new ArrayList<InputListener>();
    }
    protected void addInputListener(InputListener inputListener) {
    	listeners.add(inputListener);
    }
    
    protected void removeInputListener(InputListener inputListener) {
    	listeners.remove(inputListener);
    }
    
    public void mouseMoved(MouseEvent e) {
       x = e.getX();
       y = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
       x = e.getX();
       y = e.getY();
    }
    
    protected Vector2 getMousePosition() {
    	return new Vector2(x,y);
    }
    public void mouseClicked(MouseEvent e) { 

    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
    	for(InputListener listener : listeners) {
    		listener.mousePressed(e);
    	}
    }
    public void mouseReleased(MouseEvent e) {
    	for(InputListener listener : listeners) {
    		listener.mouseReleased(e);
    	}
    }

	@Override
	public void keyPressed(KeyEvent arg0) {
		for(InputListener listener : listeners) {
			listener.keyPressed(arg0);
		}		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		for(InputListener listener : listeners) {
			listener.keyReleased(arg0);
		}	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
	
}
