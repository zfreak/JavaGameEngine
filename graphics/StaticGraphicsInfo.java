package graphics;

/**
 * Currently only stores the current width and height of the screen
 * 
 * @author Daniel Assumpcao 
 */
public class StaticGraphicsInfo
{
    private static int width;
    private static int height;
    protected static void setDimensions(int width, int height) {
    	StaticGraphicsInfo.width = width;
    	StaticGraphicsInfo.height = height;
    }
    
    /**'
     * Gets the width of the window
     * @return the width of the window
     */
    public static int getWidth() {
    	return width;
    }
    
    /**
     * Gets the height of the window
     * @return the height of the window
     */
    public static int getHeight() {
    	return height;
    }
}
