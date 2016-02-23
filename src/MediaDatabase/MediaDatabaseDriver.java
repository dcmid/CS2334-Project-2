package MediaDatabase;
import java.util.regex.PatternSyntaxException;//imported to all for matching character sequences


import java.io.BufferedReader;
import java.io.BufferedWriter; //imported to allow for buffered reading of movie text file
import java.io.FileReader;
import java.io.FileWriter; //imported to allow buffer reader to work on importing file
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; //required to read user input 

/**
 * Project #2
 * CS 2334, Section 10
 * Feb 29, 2016
 * <P>
 * MediaDatabaseDriver is the driver class for a media database.
 * The class reads in a movie database file and a series database file whose name strings are
 * passed in using args. As it reads each of the files in the text line will be parsed 
 * and data added into the appropriate variables in a media (Episode, TV SERIES, MOVIE) object.
 * Once the line is completed translated into the Media object 
 * the object is added to the MDb to allow searching on an ArrayList for various parameters 
 * like title, year, releaseType, etc. Once the file is completely read in the program will run
 * a user dialogue using scanner and console window to request search actions 
 * on movie database(s) from user.  
 * </P>
 * @author Darin Chambers
 * @version 1.0
 */
public class MediaDatabaseDriver {

	public static void main(String[] args) {
		
		/** Driver variables */
		
		/** new array list of Media */
		MDb media = new MDb();
		/** new Array list to store Media IDs from search results */
		ArrayList<Integer> results = new ArrayList<Integer>();
		/** String to retain yearSearch - individual years and ranges of years*/
		String[] yearSearch = new String[15];
		/** Scanner input to allow for user dialog via keyboard and console*/
		Scanner input = new Scanner(System.in);//initialize scanner to send to methods for user input
	}
	
	/**
	 * Method to read Movie fileName into Movie then add to Media array
	 * 
	 * @param media
	 * @param fileName
	 */
	public static void readMovieFileIn(MDb media, String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName); //create FileReader variable on new fileName
		BufferedReader br = new BufferedReader(fr); // create BufferedReader on FileReader variable
		String nextLine = ""; //String to put read line into for passing to parsing method
		Movie newMovie = null; //create Movie variable to load parsed line into
		
		while(nextLine!=null){ //Buffered reader loads in null if no new lines - continue until null found
			nextLine = (br.readLine());//read next line used buffered reader
			
			if(nextLine!=null){ //as long as last line read is not null 
				
				newMovie = new Movie(media.size()); //create New Movie
				newMovie = parseMovieLine(newMovie,nextLine); //parsed read line into newMovie
				media.add(newMovie); //Add newMovie into MDb movies
				System.out.println(newMovie.toString()); //Print out each movie to show user in console
			}
		}
						
		fr.close(); //close file reader
		br.close(); //close buffered reader
			
	}
	
	/**
	 * Method to read Series fileName into Series/Episode than add to Media Array
	 * 
	 * @param media
	 * @param fileName
	 */
	public static void readSeriesFileIn(MDb media, String fileName) throws IOException{
		
		FileReader fr = new FileReader(fileName); //create FileReader variable on new fileName
		BufferedReader br = new BufferedReader(fr); // create BufferedReader on FileReader variable
		String nextLine = ""; //String to put read line into for passing to parsing method
		Episode newEpisode;
		TVSeries newTVSeries;
		
		while(nextLine!=null){ //Buffered reader loads in null if no new lines - continue until null found
			nextLine = (br.readLine());//read next line used buffered reader
			if(nextLine!=null && nextLine.contains("{")){
				
				newEpisode = new Episode(media.size()); //create New episode
				newEpisode = parseEpisodeLine(newEpisode,nextLine); //parsed read line into episode
				for(Media m: media.getMedia()){
					if(m.isTVSeries() && newEpisode.getUniqueSeriesTitle().equalsIgnoreCase(((TVSeries) m).getUniqueTitle())){
							((TVSeries)m).add(newEpisode); //Add newEpisode into correct TVSeries arrayList of episodes
							continue;
					}
				}
				System.out.println(newEpisode.toString()); //Print out each movie to show user in console
			}
			else if(nextLine!=null && !nextLine.contains("{")){ //as long as last line read is not null 
				
				newTVSeries = new TVSeries(media.size()); //create New Series
				newTVSeries = parseSeriesLine(newTVSeries,nextLine); //parsed read line into newSeries
				media.add(newTVSeries); //Add newMovie into MDb movies
				System.out.println(newTVSeries.toString()); //Print out each TVSeries to show user in console
			}
		}
						
		fr.close(); //close file reader
		br.close(); //close buffered reader	
	}

	/**
	 * Method to write output file from user search
	 * 
	 * @param media
	 * @param results
	 * @param searchOutline
	 * @param sortTypeFlag
	 */
	public static void writeOutputFile(MDb media, ArrayList<Integer> results, 
									String searchOutline, boolean sortTypeFlag){
		
	}

	/**
	 * Parser for Movie string in movie file - once parsed adds to newMovie
	 * 
	 * @param newMovie
	 * @param fileLine
	 * @return Movie
	 */
	public static Movie parseMovieLine(Movie newMovie, String fileLine){
		Integer releaseYear = null; //string to store year info into
		int year = 0;
		String mediaLine = fileLine.trim();
		String yearString = "";
		String title = null; //string to store title info into 
		Roman edition = new Roman(); //create new Roman variable for edition information
		ReleaseType releaseType = null; //create ReleaseType enum variable - set to null
		String testString; //establish testString to use during parsing
		char testCharacter; //establish testCharacter to use for testing
		boolean releaseTypeSet = false; //Flag on if releaseType is set
		boolean checkSecondYear = false;
		
					
		fileLine = fileLine.trim(); //trim beginning and ending white space from fileLine
		
		//collect year information in String contained at end of each fileLine
		yearString = fileLine.substring(fileLine.length()-4,fileLine.length());
		
		if(!yearString.equals("????")){ //if movie has released date check for valid year
			releaseYear =  Integer.valueOf(yearString); //create int from year data to check valid
			year = (int) releaseYear;
			if(year <1895 || year > 2030) {
				releaseYear = null; //if year information is bad <1895 or >2030 then use default for unreleased
				checkSecondYear = true;
			}
		}
		else {
			releaseYear = null; //if ???? set to database internal default
			checkSecondYear = false;
		}
		//trim off the year and then any whitespace on end of fileLine
		fileLine = fileLine.substring(0,fileLine.length()-5).trim();
		
		//Set a test string of 3 characters which could be ??), DD), /I), II), (V), TV)
		//D-stands for Digit, I - stands for Roman Numeral
		testString = fileLine.substring(fileLine.length()-3,fileLine.length());
		
		//set testCharacter to first character in testString which could be {?,D,/,I,(,T}
		testCharacter = testString.charAt(0);
		
		//If Else to check if Video or TV releaseType ( or T is next grouping in fileLine
		if(testCharacter == '('){
			//set ReleaseType to video 
			releaseType = ReleaseType.VIDEO;
			releaseTypeSet = true; //releaseType set
			//trim fileLine of releaseType and white space
			fileLine = fileLine.substring(0,fileLine.lastIndexOf("(")).trim();
			//set new testString and testCharacter
			testString = fileLine.substring(fileLine.length()-3,fileLine.length());
			testCharacter = testString.charAt(0);
		}
		else if(testCharacter =='T'){
			//set ReleaseType to TV
			releaseType = ReleaseType.TVMOVIE;
			releaseTypeSet = true;//releaseType set
			//trim fileLIne of releaseType and whitespace 
			fileLine = fileLine.substring(0,fileLine.lastIndexOf("(")).trim();
			//set new testString and testCharacter
			testString = fileLine.substring(fileLine.length()-3,fileLine.length());
			testCharacter = testString.charAt(0);
		}
		
		//Note: year in parenthesis is ignored in favor of last year 
		
		//check if testCharacter is a digit or ? meaning parse it as year
		if(Character.isDigit(testCharacter)||testCharacter == '?'){
			//grab title from beginning and remove white space between title and (year)
			title = fileLine.substring(0,fileLine.length()-6).trim();
			if(!releaseTypeSet)
				releaseType = ReleaseType.SCREEN; //if releaseType isn't set then set to Screen
			
			//If year on end of fileLine was bad then possibly take year in () after title
			if(checkSecondYear){
				testString = fileLine.substring(fileLine.indexOf("(")+1,fileLine.lastIndexOf(")"));
				if(!testString.equals("????")){
					releaseYear = Integer.valueOf(yearString);
					year = (int) releaseYear;
				}
				if(!testString.equals(yearString)&& (year >1895 && year < 2030)){
					releaseYear = Integer.valueOf(testString);
				}
					
			}
		}
		else { //get edition information from FileLine
			//grab title from beginning and remove white space between title and (year)
			title = fileLine.substring(0,fileLine.lastIndexOf("/")-5).trim();
			//set Roman edition information based on information after /
			edition.setRomanNumeral(fileLine.substring(fileLine.lastIndexOf("/")+1,
					fileLine.lastIndexOf(")")));
			if(!releaseTypeSet)
				releaseType = ReleaseType.SCREEN; //
			
			//If year on end of fileLine was bad then possibly take year in () after title
			if(checkSecondYear){
				testString = fileLine.substring(fileLine.indexOf("(")+1,fileLine.lastIndexOf("/"));
				if(!testString.equals("????"))
					year = (int) Integer.valueOf(yearString);
				if(!testString.equals(yearString) && year >1895 && year < 2030)
					yearString = testString;
			}
		
		}		
		
		
 		//Set newMovie parameters to parsed information and then return newMovie
		newMovie.setTitle(title);
		newMovie.setReleaseType(releaseType);
		newMovie.setReleaseYear(releaseYear);
		newMovie.setEdition(edition);
		newMovie.setMediaLine(mediaLine);
		return newMovie;
	
	
	
	
	}

	/**
	 * Parser for TVSeries string in series file - once parsed adds to newSeries
	 * 
	 * @param newSeries
	 * @param fileLine
	 * @return TVSeries
	 */
	public static TVSeries parseSeriesLine(TVSeries newSeries, String fileLine){
		
		String mediaLine = fileLine.trim();
		String title = null;
		String stringYear = null;
		Integer releaseYear = null;
		String uniqueTitle = null; 
		Integer endingYear = null;//year end of series run - if no end run year then null
		ArrayList<Episode> episodes = new ArrayList<Episode>(); //array of episodes for that TV Series
		
		title = mediaLine.substring(1, mediaLine.indexOf(1,'\"'));
		uniqueTitle = mediaLine.substring(0,mediaLine.indexOf(')')+1);
		stringYear = mediaLine.substring(mediaLine.indexOf('('),mediaLine.indexOf(')'));
		releaseYear = Integer.valueOf(stringYear);
		stringYear = mediaLine.substring(mediaLine.length()-4,mediaLine.length());
		if(stringYear.equals("????"))
			endingYear = null;
		else
			endingYear = Integer.valueOf(stringYear);
		
		newSeries.setMediaLine(mediaLine);
		newSeries.setTitle(title);
		newSeries.setReleaseYear(releaseYear);
		newSeries.setUniqueTitle(uniqueTitle);
		newSeries.setEpisodes(episodes);
		newSeries.setEndingYear(endingYear);
		newSeries.setReleaseType(ReleaseType.TV);
		return newSeries;
		
	}
	
	/**
	 * Parser for Episode string in series file - once parsed adds to newSeries
	 * 
	 * @param newEpisode
	 * @param fileLine
	 * @return Episode
	 */
	public static Episode parseEpisodeLine(Episode newEpisode, String fileLine){
		
		String mediaLine = fileLine.trim();
		String title = null;
		String stringYear = null;
		Integer releaseYear = null;
		String uniqueTitle = null; 
		String status = null;
		String broadcastInfo = null;
		
		uniqueTitle = mediaLine.substring(0,mediaLine.indexOf(')')+1);
		stringYear = mediaLine.substring(mediaLine.length()-4,mediaLine.length());
		if(stringYear.equals("????"))
			releaseYear = null;
		else
			releaseYear = Integer.valueOf(stringYear);
		
			
		
		
		return null;
	
	}

	/**
	 * Method to manage userDialog using scanner and console
	 * 
	 * @param media
	 * @param yearSearch
	 * @param results
	 * @param input
	 */
	public static void userDialog(MDb media, String[] yearSearch,
			                        ArrayList<Integer> results, Scanner input){
		
	}

	/**
	 * Method to search text in Media array
	 * 
	 * @param media
	 * @param searchString
	 * @param episodesIn
	 * @param exact
	 * @param results
	 * @return ArrayList<Integer>
	 */
	public static ArrayList<Integer> searchTextInMedia(MDb media, String searchString, 
														boolean episodesIn, boolean exact,
														ArrayList<Integer> results){
	
		return null;
	}

	/**
	 * Method to search year(s) in Media array
	 * 
	 * @param media
	 * @param yearSearch
	 * @param episodesIn
	 * @param results
	 * @return ArrayList<Integer>
	 */
	public static ArrayList<Integer> searchYearInMedia(MDb media, String[] yearSearch, 
										boolean episodesIn, ArrayList<Integer> results){
		return null;
	}


}
