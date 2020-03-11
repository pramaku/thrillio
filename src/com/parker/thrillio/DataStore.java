package com.parker.thrillio;

import com.parker.thrillio.constants.BookGenre;
import com.parker.thrillio.constants.Gender;
import com.parker.thrillio.constants.MovieGenre;
import com.parker.thrillio.constants.UserType;
import com.parker.thrillio.entities.Bookmark;
import com.parker.thrillio.entities.User;
import com.parker.thrillio.entities.UserBookmark;
import com.parker.thrillio.managers.BookmarkManager;
import com.parker.thrillio.managers.UserManager;

public class DataStore
{
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPE_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	private static User[] users = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPE_COUNT][BOOKMARK_COUNT_PER_TYPE];
	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmakrIndex = 0;
	
	public static void loadData()
	{
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadBooks()
	{
		final BookmarkManager mgr = BookmarkManager.getInstance();
		bookmarks[2][0] = mgr.createBook(4000L,"Walden","", 1854,	"Wilder Publications",	new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		bookmarks[2][1] = mgr.createBook(4001L,"Self-Reliance and Other Essays","", 1993,	"Dover Publications",	new String[] {"Ralph Waldo Emerson"},BookGenre.PHILOSOPHY,4.5);
		bookmarks[2][2] = mgr.createBook(4002L,"Light From Many Lamps","", 1988,	"Touchstone",	new String[] {"Lillian Eichler Watson"},BookGenre.PHILOSOPHY,5.0);
		bookmarks[2][3] = mgr.createBook(4003L,"Head First Design Patterns","", 2004,	"O'Reilly Media",	new String[] {"Eric Freeman","Bert Bates","Kathy Sierra","Elisabeth Robson"},BookGenre.TECHNICAL,4.5);
		bookmarks[2][4] = mgr.createBook(4004L,"Effective Java Programming Language Guide","", 2007,	"Prentice Hall",	new String[] {"Joshua Bloch"},BookGenre.TECHNICAL,4.9);
	}

	private static void loadMovies()
	{
		final BookmarkManager mgr = BookmarkManager.getInstance();
		bookmarks[1][0] = mgr.createMovie(3000L, "Citizen Kane", "", 1941, new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"}, MovieGenre.CLASSICS, 8.5);
		bookmarks[1][1] = mgr.createMovie(3001L, "The Grapes of Wrath", "", 1940, new String[] {"Henry Fonda","Jane Darwell"},new String[] {"John Ford"}, MovieGenre.CLASSICS, 8.2); 
		bookmarks[1][2] = mgr.createMovie(3002L, "A Touch of Greatness", "", 2004, new String[] {"Albert Cullum"},new String[] {"Leslie Sullivan"}, MovieGenre.DOCUMENTARIES, 7.3); 
		bookmarks[1][3] = mgr.createMovie(3003L, "The Big Bang Theory", "", 2007, new String[] {"Kaley Cuoco","Jim Parsons"},new String[] {"Chuck Lorre","Bill Prady"}, MovieGenre.TV_SHOWS, 8.7); 
		bookmarks[1][4] = mgr.createMovie(3004L, "Ikiru", "", 1952, new String[] {"Takashi Shimura","Minoru Chiaki"},new String[] {"Akira Kurosawa"}, MovieGenre.FOREIGN_MOVIES, 8.4); 	
	}

	private static void loadWebLinks()
	{
		final BookmarkManager mgr = BookmarkManager.getInstance();
		bookmarks[0][0] = mgr.createWebLink(2000L,"Taming Tiger, Part 2","","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
		bookmarks[0][1] = mgr.createWebLink(2001L,"How do I import a pre-existing Java project into Eclipse and get up and running?","", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running","http://www.stackoverflow.com");
		bookmarks[0][2] = mgr.createWebLink(2002L,"Interface vs Abstract Class","","http://mindprod.com/jgloss/interfacevsabstract.html","http://mindprod.com");
		bookmarks[0][3] = mgr.createWebLink(2003L,"NIO tutorial by Greg Travis","","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf","http://cs.brown.edu");
		bookmarks[0][4] = mgr.createWebLink(2004L,"Virtual Hosting and Tomcat","","http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");
	}

	private static void loadUsers()
	{
		users[0] = UserManager.getInstance().createUser(1000L,"user0@semanticsquare.com","test","John","M",Gender.MALE,UserType.USER);
		users[1] = UserManager.getInstance().createUser(1001L,"user1@semanticsquare.com","test","Sam M","M",Gender.MALE,UserType.USER);
		users[2] = UserManager.getInstance().createUser(1002L,"user2@semanticsquare.com","test","Anita","M",Gender.FEMALE,UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1003L,"user3@semanticsquare.com","test","Sara","M",Gender.FEMALE,UserType.EDITOR);
		users[4] = UserManager.getInstance().createUser(1004L,"user4@semanticsquare.com","test","Dheeru","M",Gender.MALE,UserType.CHEIFEDITOR);
	}

	public static User[] getUsers()
	{
		return users;
	}

	public static Bookmark[][] getBookmarks()
	{
		return bookmarks;
	}

	public static void add(UserBookmark userBookmark)
	{
		userBookmarks[bookmakrIndex++] = userBookmark;
	}
}
