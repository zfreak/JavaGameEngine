package graphics;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;


class DrawFrame extends JFrame {
    /**
     * This is the JFrame which contains the Jpanel.
	 * It is a seperate class because it is more object oriented
	 * It is responsible for getting the graphics from the jpanel,
	 * It is also responsible for disposing of it, but that might be given to the draw handler later 
	 */
	private static final long serialVersionUID = 1L;
	//The actual panel
	private ColorPanel panel;
    
	protected DrawFrame(int width, int height) {
		 setTitle("Game"); //Later will be a parameter
		 
	     setTheSize(width, height); 
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     setResizable(false); //Very important, otherwise will lead to bugs
	     
	     setVisible(true);
	     
	     panel = new ColorPanel(Color.black, width, height); //Creates new panel, later color will be a parameter
	     Container pane = getContentPane();
	     pane.add(panel);
	     panel.makeBufferStategy(); //Makes buffer strategy for cleaner rendering
	}

	/**
	 * Sets the size of the screen
	 * @param width
	 * @param height
	 */
	private void setTheSize(int width, int height) {
		//These are set so other pieces of the game can find out the size of the window
	    StaticGraphicsInfo.setDimensions(width, height);
	    setSize(width,height);
	}
	
	/**
	 * Prepares the object for rendering by getting  the grahics object and clearing it
	 */
    protected synchronized Graphics prepareRender()
    {
    	Graphics g = panel.getDrawingGraphics();
    	panel.fillWithBackColor(g);
        return g;
    }
    
	/**
	 *Finishes the render by sending message to panel
     *Also disposes of graphics object
	 */
    protected synchronized void finishRender(Graphics g) {
    	panel.finishDraw();
    	g.dispose();
    }
    
}
