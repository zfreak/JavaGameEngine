package graphics;

import input.Input;

import java.awt.*;
import java.awt.image.BufferStrategy;
class ColorPanel extends Canvas
{
	private static final long serialVersionUID = 1L;
	private Color backColor;
	private BufferStrategy bufferStrategy;
    public ColorPanel(Color backColor, int width, int height)
    {
    	//Has to keep the backColor so it can clear the screen
    	this.backColor = backColor;
        setBackground(backColor);
        //Adds input listeners
        addMouseListener(Input.getInternalInputHandler());
        addMouseMotionListener(Input.getInternalInputHandler());
        addKeyListener(Input.getInternalInputHandler());
        setFocusable(true);
        requestFocus();
        Dimension dim = new Dimension(width, height);
        this.setMinimumSize(dim);
        this.setMaximumSize(dim);

    }
    
    /**
     * Creates the buffer strategy for setup
     */
    protected void makeBufferStategy() {
    	//Creates the buffer strategy, handles everything needed
	    createBufferStrategy(2);
	    bufferStrategy = getBufferStrategy();
    }
    
    /**
     * Essentialy clears the graphics object, by filling it with the original color
     */
    protected void fillWithBackColor(Graphics g) {
    	g.setColor(backColor);
    	g.fillRect(0, 0, StaticGraphicsInfo.getWidth(), StaticGraphicsInfo.getHeight());
    }
    
    /**
     * Gets this graphics object
     * @return The graphics object
     */
	public Graphics getDrawingGraphics() {
		return bufferStrategy.getDrawGraphics();
	}
    
	/**
	 * Shows the current buffer strategy
	 */
	protected void finishDraw() {
		if(!bufferStrategy.contentsLost()) {
			bufferStrategy.show();
		}
		Toolkit.getDefaultToolkit().sync();
	}



}
