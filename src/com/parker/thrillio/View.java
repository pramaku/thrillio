package com.parker.thrillio;

import com.parker.thrillio.constants.KidFriendlyStatus;
import com.parker.thrillio.constants.UserType;
import com.parker.thrillio.controllers.BookmarkController;
import com.parker.thrillio.entities.Bookmark;
import com.parker.thrillio.entities.User;
import com.parker.thrillio.partner.Sharable;

public class View {
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPE_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

			BookmarkController.getInstance().saveUserBookmark(user, bookmark);
			System.out.println(bookmark);
		}
	}

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items ...");
		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean bookmarked = getBookmarkDecision(bookmark);
					if (bookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("\n New item   " + bookmark + " bookmarked ");
					}
				}

				
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHEIFEDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equalsIgnoreCase(KidFriendlyStatus.UNKNOWN.toString())) {
						String status = getKidFriendlyStatusDecision(bookmark);
						if (!status.equals(KidFriendlyStatus.UNKNOWN.toString().toLowerCase())) {
							BookmarkController.getInstance().setKidfriendlyStatus(user, status, bookmark);
						}
					}
				}
				
				// sharing.
				if (bookmark.getKidFriendlyStatus().equalsIgnoreCase(KidFriendlyStatus.APPROVED.toString())) {
					if (bookmark instanceof Sharable) {
						boolean isShared = getSharingStatusDecision(bookmark);
						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
				}
			}
		}

	}

	// TODO: Take user input to take the decision.
	private static boolean getSharingStatusDecision(Bookmark bookmark)
	{
		return Math.random() < 0.5;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		String status = "";

		double num = Math.random();
		if (num < 0.4) {
			status = KidFriendlyStatus.APPROVED.toString().toLowerCase();
		} else if (num >= 0.4 && num < 0.8) {
			status = KidFriendlyStatus.REJECTED.toString().toLowerCase();
		} else {
			status = KidFriendlyStatus.UNKNOWN.toString().toLowerCase();
		}

		return status;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5;
	}
}
