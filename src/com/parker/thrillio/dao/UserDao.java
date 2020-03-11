package com.parker.thrillio.dao;

import com.parker.thrillio.DataStore;
import com.parker.thrillio.entities.User;

public class UserDao
{
	public User[] getUsers()
	{
		return DataStore.getUsers();
	}
}
