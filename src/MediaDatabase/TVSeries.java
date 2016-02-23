package MediaDatabase;

import java.util.ArrayList;

/**
 * Project #2
 * CS 2334, Section 10
 * Feb 29, 2016
 * <P>
 *  The TVSeries object is an extension of the media class 
 *  creates a TVSeries object with key information about one TV Series episode
 * </P>
 * @author Darin Chambers
 * @version 1.0
 */
public class TVSeries extends Media{
	
	/**Private TVSeries object variables*/
	//unique series title starting with Title in quotes followed by year in parenthesis
	// used for finding correct series for episode
	private String uniqueTitle; 
	private Integer endingYear;//year end of series run - if no end run year then null
	private ArrayList<Episode> episodes; //array of episodes for that TV Series
	
	/** TV Series constructor overload*/
	
	/**
	 * Empty TV Series constructor
	 * 
	 * @param id
	 */
	public TVSeries(int id){
		super(id);
		
	}
	
	/**
	 * TVSeries constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param uniqueTitle
	 */
	public TVSeries(int id,  String mediaLine, String uniqueTitle){
		super(id, mediaLine);
		this.uniqueTitle = null;
		this.endingYear = null;
		this.episodes = new ArrayList<Episode>();
	}
	
	/**
	 * TVSeries constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param uniqueTitle
	 * @param title
	 * @param releaseYear
	 */
	public TVSeries(int id,  String mediaLine, String uniqueTitle,
	                          String title, Integer releaseYear){
			
			super(id, mediaLine, title, releaseYear);
			this.endingYear = null;
			this.episodes = new ArrayList<Episode>();
		}
	
	/**
	 * TVSeries constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 * @param uniqueTitle
	 * @param releaseYear
	 * @param releaseType
	 * @param endingYear
	 */
	public TVSeries(int id, String mediaLine, String uniqueTitle, String title, 
			  		Integer releaseYear, ReleaseType releaseType, Integer endingYear){
		super(id, mediaLine, title, releaseYear, releaseType);
		this.uniqueTitle = uniqueTitle;
		this.endingYear = endingYear;
		this.episodes = new ArrayList<Episode>();
	}
	
	/**
	 * TVSeries constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param uniqueTitle
	 * @param title
	 * @param releaseYear
	 * @param endingYear
	 */
	public TVSeries(int id, String mediaLine, String uniqueTitle, String title, 
					Integer releaseYear, Integer endingYear){
		
		super(id, mediaLine, title, releaseYear);
		this.uniqueTitle = uniqueTitle;
		this.endingYear = endingYear;
		this.episodes = new ArrayList<Episode>();
	}
	
	/**
	 * Getter for UniqueTitle of Series
	 * @return String
	 */
	public String getUniqueTitle(){
		return uniqueTitle;
	}

	/**
	 * Setter for Unique Title of Series
	 * @param uniqueTitle
	 */
	public void setUniqueTitle(String uniqueTitle){
		this.uniqueTitle = uniqueTitle;
	}
	
	
	/**
	 * Getter for ending year of series
	 * 
	 * @return Integer
	 */
	public Integer getEndingYear() {
		return endingYear;
	}

	/**
	 * Setter for ending year of series
	 * 
	 * @param endingYear
	 */
	public void setEndingYear(Integer endingYear) {
		this.endingYear = endingYear;
	}


	/** 
	 * Getter for Episode arraylist
	 * 
	 * @return ArrayList<Episode>
	 */
	public ArrayList<Episode> getEpisodes() {
		return episodes;
	}

	/**
	 * Setter for Episode arraylist
	 * 
	 * @param episodes
	 */
	public void setEpisodes(ArrayList<Episode> episodes) {
		this.episodes = episodes;
	}
	
	/**
	 * Add arrayList add function to TVSeries.episodes
	 * 
	 * @param e
	 */
	public void add(Episode e){
		 this.episodes.add(e);
	}

	
	/**
	 * Add arrayList isEmpty function to TVSeries.episodes
	 * 
	 * @return boolean
	 */
	public boolean isEmpty(){
		return this.episodes.isEmpty();
	}
	/**
	 * Override for Episodes to String
	 * 
	 * @return String
	 * 
	 */
	@Override
	public String toString(){
		return null;
	}
	
	/**
	 * Boolean flag on if Series has a status
	 * 
	 * @return boolean
	 */
	public boolean hasStatus(){
		return true;
	}
	


}
