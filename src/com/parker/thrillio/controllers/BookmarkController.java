package com.parker.thrillio.controllers;

import com.parker.thrillio.entities.Bookmark;
import com.parker.thrillio.entities.User;
import com.parker.thrillio.managers.BookmarkManager;

public class BookmarkController
{
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController()
	{
		
	}

	public static BookmarkController getInstance()
	{
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark)
	{
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}
}
