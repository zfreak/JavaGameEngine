package HighScores;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * An entry into a high score list
 * @author Daniel
 *
 */
public class Entry implements Comparable<Object>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int score;
	
	/**
	 * Creates an entry
	 * @param name the name of the high scorer
	 * @param score the score they recieved
	 */
	public Entry(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Gets the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the score
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Rerutrns a string
	 * @return the score plus the name
	 */
	public String toString() {
		return score + " " + name;
	}

	@Override
	public int compareTo(Object arg0) {
		if(arg0 instanceof Entry) {
			return score - ((Entry)arg0).getScore();
		}
		else {
			return 0;
		}
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		score = in.readInt();
		
	}
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeInt(score);		
	}

}
