package com.parker.thrillio;

import com.parker.thrillio.entities.Bookmark;
import com.parker.thrillio.entities.User;
import com.parker.thrillio.managers.BookmarkManager;
import com.parker.thrillio.managers.UserManager;

public class AppLauncher
{
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData()
	{
		System.out.println("1. Loading data ......");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		System.out.println("Printing users: ");
		printUserData();
		
		System.out.println("Printing bookmark data: ");
		printBookmarkData();
	}

	private static void printUserData()
	{
		for (User user: users)
		{
			System.out.println(user);
		}
	}

	private static void printBookmarkData()
	{
		for(Bookmark[] bookmarkList: bookmarks)
		{
			for(Bookmark bookmark: bookmarkList)
			{
				System.out.println(bookmark);
			}
		}
	}

	public static void startBookmarking()
	{
		System.out.println("2. Bookmarking ......");
		for (User user: users)
		{
			View.bookmark(user, bookmarks);
		}
	}

	public static void main(String[] args)
	{
		loadData();
		startBookmarking();
	}
}
