package MediaDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class MediaDatabaseDriverTest extends MediaDatabaseDriver{

	@Test
	public void test() {
		/*
		 * Simple Title test
		 */
		String fileLine = "Star Trek (????) ????";
		Movie testMovie = new Movie(1);
		parseMovieLine(testMovie, fileLine);
		assertEquals("Star Trek", testMovie.getTitle());
		
		/*
		 * Simple FileLine test with title, releaseType and Year
		 */
		fileLine = "The Making of 'Star Trek: First Contact' (1996) (TV)    1996";
		parseMovieLine(testMovie,fileLine);
		assertEquals("1996", testMovie.getReleaseYear());
		assertEquals(true, testMovie.isTVMovie());
		
		/*
		 * Test unreleased movie year to ensure year value remains null in Movie
		 */
		fileLine = "New Star Trek (????) ????";
		parseMovieLine(testMovie,fileLine);
		assertEquals("New Star Trek", testMovie.getTitle());
		assertEquals((Integer)2050,testMovie.getReleaseYear());
		
		/*
		 * Test to make sure Movie doesn't get populated with years that are before film
		 * valid year should be >1895 (first movie made)
		 */
		fileLine = "Bad Movie Year (1850) 1850";
		parseMovieLine(testMovie,fileLine);
		assertEquals("Bad Movie Year", testMovie.getTitle());
		assertEquals(null,testMovie.getReleaseYear());
		
		/*
		 * Test to make sure Movie accommodates discrepancy years 
		 * If discrepancy years are provided keep the last year in line as long as >1895
		 */
		fileLine = "Another Bad Year (1945) 1975";
		parseMovieLine(testMovie, fileLine);
		assertEquals("Another Bad Year", testMovie.getTitle());
		assertEquals("1975",testMovie.getReleaseYear());
		
		/*
		 * Simple File Line test for Episode
		 */
		fileLine = "\"Star Trek Continues\" (2013) {(#1.7)}			2016";
		Episode testEpisode = new Episode(1);
		parseEpisodeLine(testEpisode, fileLine);
		assertEquals(null, testEpisode.getTitle());
		assertEquals((Integer)2016, testEpisode.getReleaseYear());
		assertEquals((Integer)1,testEpisode.getSeriesYear());
		
		
		/*
		 * Simple FileLine test for Series
		 */
		fileLine = "\"Star Trek: GENESIS\" (2012)				2012-????";
		TVSeries testSeries = new TVSeries(1);
		parseSeriesLine(testSeries,fileLine);
		assertEquals("Star Trek: GENESIS", testSeries.getTitle());
		assertEquals(true, testSeries.isTVSeries());
		assertEquals(null, testSeries.getEndingYear());
		
	}		
}
