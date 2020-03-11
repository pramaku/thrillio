package com.parker.thrillio.entities;

import com.parker.thrillio.constants.KidFriendlyStatus;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN.toString().toLowerCase();
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public abstract boolean isKidFriendlyEligible();

	public String getKidFriendlyStatus()
	{
		// TODO Auto-generated method stub
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus)
	{
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
	
}
