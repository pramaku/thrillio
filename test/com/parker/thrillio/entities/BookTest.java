package com.parker.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.parker.thrillio.constants.BookGenre;
import com.parker.thrillio.managers.BookmarkManager;

public class BookTest
{
	final BookmarkManager mgr = BookmarkManager.getInstance();

	@Test
	public void testPhilosophyGenreNotKidFriendly()
	{
		Book book = mgr.createBook(4000L,"Walden","", 1854,	"Wilder Publications",	new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		assertFalse("Philosophy book should not be marked as kid friendly", book.isKidFriendlyEligible());
	}

	@Test
	public void testSelfHelpGenreNotKidFriendly()
	{
		Book book = mgr.createBook(4000L,"Walden","", 1854,	"Wilder Publications",	new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		assertFalse("Selfhelp book should not be marked as kid friendly", book.isKidFriendlyEligible());
	}

	@Test
	public void testNonPhilosophyelfhelpGenreNotKidFriendly()
	{
		Book book =  mgr.createBook(4000L,"Walden","", 1854,	"Wilder Publications",	new String[] {"Henry David Thoreau"},BookGenre.CHILDREN,4.3);
		assertTrue("Children book can be marked as kid friendly", book.isKidFriendlyEligible());
	}

}
