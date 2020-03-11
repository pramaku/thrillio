package com.parker.thrillio.managers;

import com.parker.thrillio.dao.BookmarkDao;
import com.parker.thrillio.entities.Book;
import com.parker.thrillio.entities.Bookmark;
import com.parker.thrillio.entities.Movie;
import com.parker.thrillio.entities.User;
import com.parker.thrillio.entities.UserBookmark;
import com.parker.thrillio.entities.WebLink;

public class BookmarkManager
{
	private static BookmarkManager instance = new BookmarkManager();
	private static BookmarkDao dao = new BookmarkDao();
	private BookmarkManager()
	{
		
	}

	public static BookmarkManager getInstance()
	{
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors,String genre, double imdbRating)
	{
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);
		return movie;
	}

	public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher, String[] authors, String genre, double amazonRating)
	{
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
	}

	public WebLink createWebLink(long id, String title, String profileUrl, String url, String host)
	{
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);
		return weblink;
	}

	public Bookmark[][] getBookmarks()
	{
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark)
	{
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidfriendlyStatus(User user, String status, Bookmark bookmark)
	{
		bookmark.setKidFriendlyStatus(status);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Bookmark " + bookmark + " marked kidfriendly - " + status + " by " + user);
	}

	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Bookmark " + bookmark + " shared by " + user);
		
		if (bookmark instanceof Book)
		{
			Book book = (Book)bookmark;
			System.out.println("Sending Book data to Good reads:" + book.getItemData());
		}
		else if (bookmark instanceof WebLink)
		{
			WebLink webLink = (WebLink)bookmark;
			System.out.println("Sending WebLink data to Good reads:" + webLink.getItemData());
		}
		else
		{
			System.out.println("Bookmark " + bookmark + " cannot be shared");
		}
	}
}
