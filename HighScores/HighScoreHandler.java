package HighScores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * Handles loading, managing, and saving high scores
 *
 */
public class HighScoreHandler {
    private Entry[] highScores;
    private String fileName;
    
    public HighScoreHandler() {
    	highScores = new Entry[10];
    	fileName = "HighScores.txt";
    	loadHighScores();
    }
    
    public HighScoreHandler(String fileName) {
    	highScores = new Entry[10];
    	this.fileName = fileName;
    	loadHighScores();
    }
    
    /**
     * Loads the high score
     */
    private void loadHighScores() {
    	ObjectInputStream source = null;
    	try {
    		source = new ObjectInputStream(new FileInputStream(fileName));
    		highScores = (Entry[]) source.readObject();
    	} catch(Exception e) {
    		//If it fails it will create a blank high score and save a new file
    		for (int i = 0; i < highScores.length; i++) {
				highScores[i] = new Entry("",100);
			}
    		saveHighScores();
    	} finally {
    		try {
    			source.close();
    		} catch (Exception e) {
    		}
    	}
    
    }
    

    
    /**
     * Adds the score to the high score list if its high enough. If it does, returns true. If not returns false.
     * @param score the score to add to your high school
     * @return whether or not the score made the top 10 score list
     */
    public boolean addToHighScores(int score) {
    	if(score < highScores[9].getScore()) {
    		String name = JOptionPane.showInputDialog(null, "You got a high score! Enter your name in the box below!");
    		highScores[9] = new Entry(name, score);
    		Arrays.sort(highScores);
    		saveHighScores();
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Saves the high score to a high score file
     */
    private void saveHighScores() {
    	File file = null;
    	try {
			file = new File(fileName);
			if(file.exists()) {
				file.delete();
			}
			file.createNewFile();
			FileOutputStream stream = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(stream);
			out.writeObject(highScores);
			out.flush();
			out.close();
			
		} catch (Exception e) {
		
		}
    	
    }
    
    /***
     * Gets the high scores in array form
     * @return array of high score entries
     */
    public Entry[] getHighScores() {
    	return highScores.clone();
    }



}