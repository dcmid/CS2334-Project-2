package MediaDatabase;
/**
 * Project #2
 * CS 2334, Section 10
 * Feb 29, 2016
 * <P>
 * This MDB class maintains an ArrayList of media objects specified by content
 * </P>
 * @author Darin Chambers
 * @version 1.0
 */

import java.util.ArrayList; //import ArrayList to use as MDb private variable
import java.util.Collections; //import Collections to Sort ArrayList of media
import java.util.Comparator;// import Comparator to build comparator for Media



public class MDb {
	
	/**
	 * MDb ArrayList of Media
	 */
	private ArrayList<Media> media;
	
	
	/**
	 * Empty Constructor for MDb
	 */
	
	public MDb(){
		media = new ArrayList<Media>();
	
	}
	
	
	/**
	 * Getter function for MDb on media array
	 * @return ArrayList<Media>  MDb to return
	 */
	public ArrayList<Media> getMedia(){
		return this.media;
	}
	
	/**
	 * ArrayList add function for MDb 
	 * @param m    Media to add
	 */
	public void add(Media m){
		 this.add(m);
	}

	
	/**
	 * ArrayList sort function to use Collections sort for MDb based on media Comparator sent
	 * 
	 */
	public void sort(Comparator<Media> c){
		
		Collections.sort(this.media,c);
	}
	
	
	/**
	 * ArrayList size function for MDb Class
	 * @return int
	 */
	public int size(){
		
		return this.media.size();
	}
	
	
	
	/**
	 * ArrayList isEmpty function for MDb 
	 * @return boolean
	 */
	public boolean isEmpty() {
		
		return this.media.isEmpty();
	}

}

