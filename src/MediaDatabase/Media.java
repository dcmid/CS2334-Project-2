
package MediaDatabase;

import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 10
 * Feb 29, 2016
 * <P>
 * The Media class creates an object with key information about a media type
 * </P>
 * @author Darin Chambers
 * @version 1.0
 */

public class Media implements Comparable<Media> {
	
	/** Media class variables */
	
	/**Comparator variables used for comparator of Media objects*/
	public static final Comparator<Media> TITLE_FIRST_COMPARATOR = new TitleFirstComparator();
	public static final Comparator<Media> YEAR_FIRST_COMPARATOR = new YearFirstComparator();
	/** retain original string of media from file to use during output*/
	private String mediaLine;
	/** give each media object its own unique id identifier to track search results*/
	private int id;
	/**  Title stores the title of the media object */
	private String title; //Inherited Title for Episode is the actual Episode title not Series title
	/** releaseYear stores the year the media item was released */
	private Integer releaseYear;//Inherited releaseYear for Episode is actual episode run not Series start
	/** releaseType stores the release type of the media saved in 
	 * enum ReleaseType - SCREEN, VIDEO, TVMOVIE, EPISODE, TV */
	protected ReleaseType releaseType;
	
	/** Media Constructor Overload */
	
	/**
	 * Empty constructor for Media
	 */
	public Media(){
		
	}
	
	/**
	 * Media constructor 
	 * 
	 * @param id
	 */
	public Media(int id){
		
	}
	
	/**
	 * Media constructor
	 * 
	 * @param id
	 * @param mediaLine
	 */
	public Media(int id, String mediaLine){
		
	}
	
	/**
	 * Media constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 */
	public Media (int id, String mediaLine, String title){
		
	}

	/**
	 * Media Constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 * @param releaseYear
	 */
	public Media (int id, String mediaLine, String title, Integer releaseYear){
		
	}

	/**
	 * Media constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 * @param releaseYear
	 * @param releaseType
	 */
	public Media (int id, String mediaLine, String title, Integer releaseYear, ReleaseType releaseType){
		
	}

	/**
	 * Getter for unique Media ID
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for unique Media ID
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for MediaLine
	 * 
	 * @return String
	 */
	public String getMediaLine() {
		
		return this.mediaLine;
	}

	/**
	 * Setter for MediaLine
	 * 
	 * @param mediaLine
	 */
	public void setMediaLine (String mediaLine){
		
	}
	
	/**
	 * Getter for Media Title 
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter for Title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Getter for Release Year
	 * 
	 * @return Integer
	 */
	public Integer getReleaseYear() {
		return releaseYear;
	}

	/**
	 * Setter for ReleaseYear
	 * 
	 * @param releaseYear
	 */
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * Getter for ReleaseType
	 * 
	 * @return ReleaseType
	 */
	public ReleaseType getReleaseType() {
		return releaseType;
	}

	/**
	 * Setter for ReleaseType
	 * 
	 * @param releaseType
	 */
	public void setReleaseType(ReleaseType releaseType) {
		this.releaseType = releaseType;
	}
	
	/**
	 * Boolean Flag to see if Media is Video
	 * 
	 * @return boolean
	 */
	public boolean isVideo(){
		return true;
	}
	
	/**
	 * Boolean Flag to see if Media is Screen
	 * 
	 * @return boolean
	 */
	public boolean isScreen(){
		return true;
		
	}
	
	/**
	 * Boolean Flag to see if Media is TVMovie
	 * 
	 * @return boolean
	 */
	public boolean isTVMovie(){
		return true;
		
	}
	
	/**
	 * Boolean Flag to see if Media is TVSeries
	 * 
	 * @return boolean
	 */
	public boolean isTVSeries(){
		return true;
	}
	
	/**
	 * Boolean Flag to see if Media is Episode
	 * 
	 * @return boolean
	 */
	public boolean isEpisode(){
		return true;
	}
	
	/**
	 * 
	 * Comparator class for Media to allow sort by Title then Year of search results
	 *
	 */
	private static class TitleFirstComparator implements Comparator<Media>{
		/**
		 * Compare method for two media items
		 * @return int
		 */
		public int compare(Media m1, Media m2){
			return 0;
		}
	};
	/**
	 * 
	 * Comparator class for Media to allow sort by Year the Title of search results
	 *
	 */
	private static class YearFirstComparator implements Comparator<Media>{
		
		/**
		 * Compare method for two media items		 * 
		 * @return int
		 */
		public int compare(Media m1, Media m2){
			return 0;
		}	
	};
	
	/**
	 * Override of toString for Media
	 * @return String
	 */
	@Override
	public String toString() {
		return this.mediaLine;
	}
	
	/**
	 * Override of compareTo for Media
	 * 
	 */
	@Override
	public int compareTo(Media m) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
	
