package Game;
import graphics.DrawHandler;
import graphics.GUIWindow;
/**
 * A game instance. Every game using this engine should have their base game class
 * extend this class. This class automatically handles the game loop. After extending this class,
 * users in their main loop should create their base game class taht extends this one, then call
 * runGame() which will automatically start the game
 * @author Daniel
 *
 */
public abstract class GameInstance {
    GUIWindow drawer;
    private long lastTime; 
    private double passed;
    
    /**
     * Creates a game with the specified with and height
     * @param width width of the game
     * @param height height of the game
     */
    public GameInstance(int width, int height) {
        lastTime = System.nanoTime(); //For finding time passed
        drawer = new GUIWindow(width,height, this);
    }
    /**
     * Initializes the game. Called once at the very beginning of the 
     * runGame method
     */
    public abstract void initialize();
    /**
     * Draws the game
     * @param drawer the DrawHandler that draws everything
     */
    public abstract void draw(DrawHandler drawer);
    /**
     * Runs the game. Should be called by users. Will automatically run the game loop.
     */
    public synchronized void runGame() {
    	initialize();
    	while(true) {
    		passed = (double)(System.nanoTime() - lastTime) / 1000000000.0;
    		if(passed > 1.0/60) {
    			lastTime = System.nanoTime(); //Calculates the elapsed time
    			update(passed); //The main update loop
        		drawer.render();
    		}
        	//The drawing happens in a separate loop
    	}
    }
    
    /**
     * Updates the game
     * @param elapsed elapsed time
     */
    public abstract void update(double elapsed);
}
