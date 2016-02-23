package MediaDatabase;


/**
 * Project #2
 * CS 2334, Section 10
 * Feb 29, 2016
 * <P>
 * The Movie is an extension of the media class 
 *  creates an object with key information about one moviee
 * </P>
 * @author Darin Chambers
 * @version 1.0
 */
public class Movie extends Media {
	
	/** private class variable for Movie*/
	private Roman edition;//tracks edition of same name movies
	
	/** Constructor Overload for Movie */
	
	/**
	 * Empty constructor for Movie
	 * 
	 * @param id
	 */
	public Movie(int id){
		super(id);
		this.edition = null;
		
	}
	
	/**
	 * Movie constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 * @param releaseYear
	 * @param edition
	 */
	public Movie(int id, String mediaLine, String title, Integer releaseYear, Roman edition){
		
		super(id, mediaLine, title, releaseYear);
		this.edition = edition;
	}
	/**
	 * Movie constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 * @param releaseYear
	 * @param releaseType
	 */
	public Movie (int id, String mediaLine, String title, Integer releaseYear, 
			                                           ReleaseType releaseType){
		super(id, mediaLine, title, releaseYear, releaseType);
		this.edition = null;
	}
	
	/**
	 * Movie constructor
	 * 
	 * @param id
	 * @param mediaLine
	 * @param title
	 * @param releaseYear
	 * @param releaseType
	 * @param edition
	 */
	public Movie(int id, String mediaLine, String title, Integer releaseYear, 
			                          ReleaseType releaseType, Roman edition){
		super(id, mediaLine, title, releaseYear, releaseType);
		this.edition = edition;
	}
	
	
	/**
	 * Getter for Edition
	 * 
	 * @return Roman
	 */
	public Roman getEdition() {
		
		return edition;
	}
	
	/**
	 * Setter for Edition
	 * 
	 * @param edition
	 */
	public void setEdition(Roman edition) {
		this.edition = edition;
	}
	
	/**
	 * Boolean flag for whether a Movie has an edition
	 * 
	 * @return boolean
	 */
	public boolean hasEdition(){
		
		return (this.edition.getNumber()!=0);
	}
	
	/**
	 * Override for Movie to String
	 * @return String
	 */
	
	 @Override
	 public String toString(){
		
		 return super.getMediaLine();
	
}
}
