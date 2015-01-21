package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.imageio.ImageIO;

/**
 * Loads images from the image folder and provides a place for users to store images
 * If the user chooses to do so
 * @author Daniel
 *
 */
public class ImageLoader {
	private static Dictionary<String, BufferedImage> images;
	private static String imageFolder = "Images";
	/**
	 * Loads an image at the specified location in teh images folder
	 * @param filePath The path to the file in the images folder
	 * @throws Exception if error occures
	 */
	public static BufferedImage loadImage(String filePath) throws Exception {
		try {
		    return ImageIO.read(new File(imageFolder + "\\" + filePath));
		} catch(Exception e) {
			throw e;
		}
	}
	
	/**
	 * Stores the image statically so that it can be accesed anywhere in the program
	 * The name is its identifier that will be used to retrieve the image
	 * @param image to be stored
	 * @param name of the image
	 */
	public static void storeImage(BufferedImage image, String name) 
	{
		images.put(name, image);
	}
	/**
	 * Gets the image stored with that name
	 * @param name name of the image
	 * @return the desired image
	 */
	public static BufferedImage getStoredImage(String name) {
		return images.get(name);
	}
	
	static {
		images = new Hashtable<String, BufferedImage>();
    }
	
	/**
	 * Sets the folder for Images if the user wants to use another file
	 * @param folderName name of the folder the user wants to use
	 */
	public static void setImageFolder(String folderName) {
		imageFolder = folderName;
	}

	
}
