package com.bemach.jersey;

public interface IFriendsDao {
	public Friend[] getFriends();
	public void removeFriend(String name);
	public void addFriend(String name);
}
