package com.parker.thrillio.dao;

import com.parker.thrillio.DataStore;
import com.parker.thrillio.entities.Bookmark;
import com.parker.thrillio.entities.UserBookmark;

public class BookmarkDao
{
	public Bookmark[][] getBookmarks()
	{
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark)
	{
		DataStore.add(userBookmark);	
	}
}
