package com.bemach.jersey;

import java.util.ArrayList;
// friend 
public class FriendsDaoImpl implements IFriendsDao{
	
	static ArrayList<Friend> friends;
	static String friendNames[] = {"lisa", "linda", "melissa", "larry", "barry", "crazy-horse"};
	static{
		friends = new ArrayList<Friend>();
		for (int idx = 0; idx < friendNames.length; idx++) {
			Friend friend = new Friend();
			friend.setName(friendNames[idx]);
			friends.add(friend);
		}
	}
	
	public static IFriendsDao getInstance() {
		return new FriendsDaoImpl();
	}
	
	public Friend[] getFriends() {
		return friends.toArray(new Friend[friends.size()]);
	}

	public void removeFriend(String name) {
		for (int idx = 0; idx < friends.size(); idx++) {
			Friend friend = friends.get(idx);
			if (friend.getName().equalsIgnoreCase(name)) {
				friends.remove(idx);
				break;
			}
		}
	}

	public void addFriend(String name) {
		Friend friend = new Friend();
		friend.setName(name);
		friends.add(friend);
	}
}
