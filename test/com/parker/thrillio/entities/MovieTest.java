package com.parker.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.parker.thrillio.constants.MovieGenre;
import com.parker.thrillio.managers.BookmarkManager;

public class MovieTest
{
	final BookmarkManager mgr = BookmarkManager.getInstance();

	@Test
	public void testHorrorGenreNotKidFriendly()
	{
		Movie movie = mgr.createMovie(3000L, "Citizen Kane", "", 1941, new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.HORROR, 8.5);
		assertFalse("Horror movie should not be marked as kid friendly", movie.isKidFriendlyEligible());
	}

	@Test
	public void testThrillerGenreNotKidFriendly()
	{
		Movie movie = mgr.createMovie(3000L, "Citizen Kane", "", 1941, new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.THRILLERS, 8.5);
		assertFalse("Thriller movie should not be marked as kid friendly", movie.isKidFriendlyEligible());
	}

	@Test
	public void testNonHorrorThrillerGenreNotKidFriendly()
	{
		Movie movie = mgr.createMovie(3000L, "Citizen Kane", "", 1941, new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.CLASSIC_MOVIE_MUSICALS, 8.5);
		assertTrue("Non horror/Thriller movie can be marked as kid friendly", movie.isKidFriendlyEligible());
	}
}
