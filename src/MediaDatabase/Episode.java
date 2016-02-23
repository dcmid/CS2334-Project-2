package MediaDatabase;
/**
 * Project #2
 * CS 2334, Section 10
 * Feb 29, 2016
 * <P>
 * The Episode is an extension of the media class 
 *  creates an episode object with key information about one TV Series episode
 * </P>
 * @author Darin Chambers
 * @version 1.0
 */

public class Episode extends Media {
	
	/**  Episode unique variables in addition Media variables */
	private String uniqueSeriesTitle; //Info on Title and Year to search Episode for common series info
	private String broadcastInfo; // Info of the broadcast (#1.08)
	private String status; //status of series (UNSPECIFIED, SUSPENDED)
	private Integer seriesYear; // Integer representation of the 1 for Year (#1.08)
	private Integer episodeNumber; //Integer representation of the 08 for Episode # (#1.08)
	// Comment by Matt 
	/** Episode Constructor Overload - 5 constructors for various parameter inputs
	
	/**
	 * empty Episode constructor that creates empty Episode
	 * 
	 * @param int
	 */
	public Episode(int id){
		super(id);
		this.uniqueSeriesTitle = null;
		this.broadcastInfo = null;
		this.setSeriesYear(null);
		this.setEpisodeNumber(null);
		
	
	}
	/**
	 * Episode Constructor
	 * @param id
	 * @param mediaLine
	 * @param uniqueSeriesTitle
	 */
	public Episode(int id, String mediaLine, String uniqueSeriesTitle){
		super(id, mediaLine);
		this.uniqueSeriesTitle = uniqueSeriesTitle;
		this.setSeriesYear(null);
		this.setEpisodeNumber(null);
	}
		
	/**
	 * Episode Constructor
	 * @param id
	 * @param mediaLine
	 * @param uniqueSeriesTitle
	 * @param title
	 * @param releaseYear
	 * @param releaseType
	 * @param status
	 * @param broadcastInfo
	 */
	public Episode(int id, String mediaLine, String uniqueSeriesTitle,String title, 
			Integer releaseYear, ReleaseType releaseType, String status, String broadcastInfo){
		
		super(id, mediaLine, title, releaseYear, releaseType);
		this.uniqueSeriesTitle = uniqueSeriesTitle;
		this.status = status;
		this.broadcastInfo = broadcastInfo;
		this.setEpisodeNumber(translateEpisodeNumber(broadcastInfo));
		this.setSeriesYear(translateSeriesYear(broadcastInfo));
	}
	
	/**
	 * Episode Constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param uniqueSeriesTitle
	 * @param title
	 * @param releaseYear
	 * @param releaseType
	 */
	public Episode (int id, String mediaLine, String uniqueSeriesTitle,
					String title, Integer releaseYear, ReleaseType releaseType){
		
		super(id, mediaLine, title, releaseYear, releaseType);
		this.uniqueSeriesTitle = uniqueSeriesTitle;
		this.broadcastInfo = null;
		this.setSeriesYear(null);
		this.setEpisodeNumber(null);
		
	}
	
		
	/**
	 * Getter for unique Series Title for this episode
	 * 
	 * @return String
	 */
	public String getUniqueSeriesTitle(){
		return uniqueSeriesTitle;
	}
	
	/**
	 * Setter for unique Series Title for this episode
	 * 
	 * @param uniqueSeriesTitle
	 */
	public void setUniqueSeriesTitle(String uniqueSeriesTitle){
		this.uniqueSeriesTitle = uniqueSeriesTitle;
		
	}
	
	/**
	 * Getter for Episode Status
	 * 
	 * @return String
	 */
	public String getStatus(){
		return status;
	}
	
	/**
	 * Setter for Episode Status
	 * 
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
	/**
	 * Getter for broadcastInfo
	 * @return String
	 */
	public String getBroadcastInfo() {
		return broadcastInfo;
	}

	/**
	 * Setter for broadcastInfo with translation of string to Year & Episode # of Series
	 * 
	 * @param broadcastInfo
	 */
	public void setBroadcastInfo(String broadcastInfo) {
		this.broadcastInfo = broadcastInfo;
		this.setEpisodeNumber(translateEpisodeNumber(broadcastInfo));
		this.setSeriesYear(translateSeriesYear(broadcastInfo));
	}
	
	/**
	 * Translate method to take broadcastInfo and set Episode # 
	 * 
	 * @param broadcastInfo
	 * @return Integer
	 */
	public Integer translateEpisodeNumber(String broadcastInfo){
		
		return null;
	}
	
	/**
	 * Translate method to take broadcastInfo and set Series Year 
	 * 
	 * @param broadcastInfo
	 * @return Integer
	 */
	public Integer translateSeriesYear(String broadcastInfo){
		
		return null;
	}
	
	/**
	 * Getter for Series Year
	 * 
	 * @return Integer
	 */
	public Integer getSeriesYear() {
		return seriesYear;
	}
	
	/**
	 * Setter for Series Year
	 * 
	 * @param seriesYear
	 */
	public void setSeriesYear(Integer seriesYear) {
		this.seriesYear = seriesYear;
	}

	/**
	 * Getter for Episode #
	 * 
	 * @return Integer
	 */
	public Integer getEpisodeNumber() {
		return episodeNumber;
	}

	/**
	 * Setter for Episode #
	 * 
	 * @param episodeNumber
	 */
	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	/**
	 * To String override for Episode
	 * 
	 * @return String
	 */
	@Override
	 public String toString(){
		
		 return super.getMediaLine();
	}
	
	
	/**
	 * Boolean flag on if Episode has a status
	 * 
	 * @return boolean
	 */
	public boolean hasStatus(){
		return true;
	}
	

}