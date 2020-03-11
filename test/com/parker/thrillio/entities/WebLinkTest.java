package com.parker.thrillio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.parker.thrillio.managers.BookmarkManager;

public class WebLinkTest
{
	@Test
	public void testIsKidFriendlyEligible()
	{
		/**
		 * Horror in url - not eligible
		 */
		final BookmarkManager mgr = BookmarkManager.getInstance();
		WebLink weblink = mgr.createWebLink(2000L,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger-horror-part-2.html","http://www.javaworld.com");
		assertFalse(weblink.isKidFriendlyEligible());

		/**
		 * Horror in title - - not eligible
		 */
		weblink = mgr.createWebLink(2000L,"Taming Tiger Horror, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		assertFalse(weblink.isKidFriendlyEligible());

		/**
		 * adult in host - - not eligible
		 */
		weblink = mgr.createWebLink(2000L,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld-adult-game.com");
		assertFalse(weblink.isKidFriendlyEligible());

		/**
		 * adult in url but not in host -- eligible
		 */
		weblink = mgr.createWebLink(2000L,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger---adult-part-2.html","http://www.javaworld-game.com");
		assertTrue(weblink.isKidFriendlyEligible());
		
		/**
		 * adult in title only - eligble.
		 */
		weblink = mgr.createWebLink(2000L,"Taming Tiger-Adult, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld--game.com");
		assertTrue(weblink.isKidFriendlyEligible());
	}
}
