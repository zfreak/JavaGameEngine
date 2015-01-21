package graphics;

import java.awt.*;

import Game.GameInstance;
/**	
 *The gui window is responsible for sending the command
 *to the level with the correct DrawHandler object
 *This is required because it sets the correct graphics object
 *Of the jframe to the drawhandler, allowing it to draw
 */
public class GUIWindow
{

	
	//The frame which we will draw to
	private DrawFrame drawFrame;
    private DrawHandler drawHandler; //The handler that will do the actual drawing
    private GameInstance game; //a reference back to the game so it can send the draw handler

    /***
     * Creates a window where the game will take place
     * @param width width of the window
     * @param height height of the window
     * @param game the game instance
     */
    public GUIWindow(int width, int height, GameInstance game) {
    	//These are set so other pieces of the game can find out the size of the window
        StaticGraphicsInfo.setDimensions(width, height);
        
        //Done allows the game to exit this and stop the thread
        //Creates the new drawhandler needed to draw
        drawHandler = new DrawHandler(width, height);
        this.game = game;
        //Creates the draw frame
        drawFrame = new DrawFrame(width, height);
        

    }
    
    /**
     * Location of the actual drawing. The drawhandler is then given to the level
     * The level provides the specifcs, such as what is drawn where
     */
    private void draw(Graphics g) {
    	//This is when the actual drawing occurs, the drawhandler is given to teh level
    	//The level says what is going to be drawn where
    	
    	drawHandler.beginDraw(g); //This gives the drawHandler the correct graphics object
    	game.draw(drawHandler); //The actual drawing
        drawHandler.finishDraw(); //Finishes the draw
    }
	
	
	/**
	 * Where the setup for the drawing occurs
	 */
	public void render() {
		//This is where the setup for the drawing occurs
		
		Graphics g = drawFrame.prepareRender(); //Gets the graphics from the jwindow
		draw(g);
		drawFrame.finishRender(g); //Allows the drawFrame to dispose of graphics and finish using it
	}
	
	/**
	 * Completes the drawing thread.
	 */


    
}

 
