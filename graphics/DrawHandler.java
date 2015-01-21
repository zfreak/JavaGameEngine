package graphics;

import gameComponents.CollisionRectangle;
import gameComponents.Vector2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

/**
 * This is the object given to the game object. The game object calls the commands here to draw things.
 * This is used to create a layer between the drawing and logic of the game. Also supports a camera, automatically
 * shifting the position of everything based on the camera position
 */
public class DrawHandler {
	//This is the object given to the game object. The game object calls the commands here to draw things.
	//This is used to create a layer between the drawing and logic of the game.
	//More drawing methods need to be added
	
	private Graphics g; //The current graphics object
	private Vector2 cameraPosition;
	private int width;
	private int height;
	protected DrawHandler(int width, int height) {
		this.width = width;
		this.height = height;
		g = null;
		cameraPosition = new Vector2(0,0);
	}
	
	/**
	 * Gets width of drawable area
	 * @return width of drawable area
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets height of drawable area
	 * @return height of drawable area
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Draws a perfect circle
	 * @param position the position of the circle
	 * @param color the color of the circle
	 * @param size the size(diameter) of the circle
	 */
	public synchronized void drawCircle(Point2D position, Color color, double size) {
		//Draws a perfect circle
		g.setColor(color);
		g.drawOval((int)position.getX() - (int)(size/2) - (int)cameraPosition.getX(), (int)position.getY() - (int)(size/2) - (int)cameraPosition.getY(), (int)size, (int)size);
	}
	 
	/**
	 * Draws a filled perfect circle
	 * @param position the position of the circle
	 * @param color the color of the circle
	 * @param size the size(diameter) of the circle
	 */
	public synchronized void drawFilledCircle(Point2D position, Color color, double size) {
		//Draws a perfect circle
		g.setColor(color);
		g.fillOval((int)position.getX() - (int)(size/2) - (int)cameraPosition.getX(), (int)position.getY() - (int)(size/2) - (int)cameraPosition.getY(), (int)size, (int)size);
	}
	
	/**
	 * Draws a hollow rectangle
	 * @param rectangle CollisionRectangle that has location of size of rectangle that will be drawn
	 * @param color color of the rectangle
	 */
	public void drawRectangle(CollisionRectangle rectangle, Color color) {
		g.setColor(color);
		g.drawRect((int)(rectangle.left() - cameraPosition.getX()), (int)(rectangle.top() - cameraPosition.getY()), rectangle.width(), rectangle.height());
	}
	
	/**
	 * Fills the screen with the specified color
	 * @param color color to fill the screen with
	 */
	public void fillScreen(Color color) {
		drawRectangle(new CollisionRectangle(0, 0, StaticGraphicsInfo.getWidth(), StaticGraphicsInfo.getHeight()), color);
	}
	
	/**
	 * Draws a filled rectangle
	 * @param rectangle CollisionRectangle that has location of size of rectangle that will be drawn
	 * @param color color of the rectangle
	 */
	public void drawFilledRectangle(CollisionRectangle rectangle, Color color) {
		g.setColor(color);
		g.fillRect((int)(rectangle.left() - cameraPosition.getX()), (int)(rectangle.top() - cameraPosition.getY()), rectangle.width(), rectangle.height());
	}
	/**
	 * Draws a line
	 * @param startingPoint starting point of the line
	 * @param endingPoint ending point of the line
	 * @param color color of the line
	 * @param thickness thickness of the line
	 */
	public synchronized void drawLine(Vector2 startingPoint, Vector2 endingPoint, Color color, double thickness) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke((float) thickness));
		g2.setColor(color);
		g.drawLine((int)startingPoint.x - (int)cameraPosition.getX(), (int)startingPoint.y - (int)cameraPosition.getY(), (int)endingPoint.x - (int)cameraPosition.getX(), (int)endingPoint.y - (int)cameraPosition.getY());
		g2.setStroke(new BasicStroke(1));
	}
	
	/**
	 * Draws an image
	 * @param i the image to be drawn
	 * @param rectangle rectangle the image will be drawn in
	 */
	public synchronized void drawImage(Image i, CollisionRectangle rectangle) {
		drawImage(i, (int)rectangle.left(), (int)rectangle.top(), rectangle.width(), rectangle.height());
	}
	
	/**
	 * Draws an image at a fixed location, ignoring the camera position
	 * @param i image to be drawn
	 * @param rectangle rectangle image will be drawn in
	 */
	public synchronized void drawImageNoCamera(Image i, CollisionRectangle rectangle) {
		drawImage(i, (int)rectangle.left() + (int)cameraPosition.getX(), (int)rectangle.top() + (int)cameraPosition.getY(), rectangle.width(), rectangle.height());
	}
	/**
	 * Draws an image
	 * @param i image to be drawn
	 * @param centerPosition position of the top left corner
	 * @param angle angle to rotate the image to
	 */
	public synchronized void drawImage(BufferedImage i, Vector2 centerPosition, double angle) {
		//Graphics2D g2 = (Graphics2D)g;
		AffineTransform at = new AffineTransform();
		at.rotate(angle, i.getWidth() /2, i.getHeight() / 2);
		AffineTransformOp scaleOp = new AffineTransformOp(
		        at, AffineTransformOp.TYPE_BILINEAR);
		drawImage(scaleOp.filter(i, null), null, (int)(centerPosition.getX() - i.getWidth() / 2 - cameraPosition.x), (int)(centerPosition.getY() - i.getHeight() - cameraPosition.y));
		//drawImage(i, (int)rectangle.left(), (int)rectangle.top(), rectangle.width(), rectangle.height());
	}
	
	/**
	 * Draws an image
	 * @param i image to be drawn
	 * @param x x value of top left corner
	 * @param y value of top left corner
	 * @param width width of the desired size
	 * @param height height of the desired size
	 */
	public synchronized void drawImage(Image i, int x, int y, int width, int height) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(i, x - (int)cameraPosition.getX(), y - (int)cameraPosition.getY(), width, height, null);
	}
	
	/**
	 * Draws an image and performs an operation to it
	 * @param i image to be drawn
	 * @param op operation to be performed
	 * @param x x value of the top left corner
	 * @param y y value of the top left corner
	 */
	public synchronized void drawImage(BufferedImage i, BufferedImageOp op, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(i, op, x - (int)cameraPosition.getX(), y - (int)cameraPosition.getY());
	}
	
	/**
	 * Draws text on the screen IGNORING CAMERA POSITION
	 * @param position  position of the text
	 * @param text actual text to be printed
	 * @param font font of the text
	 * @param color color of the text
	 */
	public synchronized void drawText(Point position, String text, Font font, Color color) {
		//Draws text to the screen
		g.setColor(color);
    	g.setFont(font);
    	g.drawString(text, (int)position.getX(), (int)position.getY());
	}
	
	/**
	 * Draws text on the screen WITH CAMERA POSITION
	 * @param position position of the text
	 * @param text actual text to be printed
	 * @param font font of the text
	 * @param color color of the text
	 */
	public synchronized void drawTextWithCamera(Point position, String text, Font font, Color color) {
		//Draws text to the screen
		g.setColor(color);
    	g.setFont(font);
    	g.drawString(text, (int)position.getX() + (int)cameraPosition.getX(), (int)position.getY() + (int)cameraPosition.getY());
	}
	
	/**
	 * Sets up the handler to be able to draw
	 * @param g the graphics object it will draw to
	 */
	 protected synchronized void beginDraw(Graphics g) {
		//Sets the graphics object. Might be more efficient to set it at the beginning.
		//That leads to more efficiency, but a little worse code
		//Also does some setup
		this.g = g;
		
        if(g instanceof Graphics2D) { //Alows text antialiasing
        	Graphics2D g2 = (Graphics2D)g;
        	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        	                        RenderingHints.VALUE_ANTIALIAS_ON);

        }
	}
	
	/**
	 * Finishes drawing, and cleans up some things.
	 */
	protected synchronized void finishDraw() {
		//Sets the graphics reference to null. Does not dispose of it
		g = null;
	}
	
	/**
	 * Sets the position of the camera
	 * @param position position of the camera
	 */
	public void setCameraPosition(Vector2 position) {
		cameraPosition = position;
	}
	
	/**
	 * Gets the position of the camera
	 * @return position of the camera
	 */
	public Vector2 getCameraPosition() {
		return cameraPosition;
	}
	


}


