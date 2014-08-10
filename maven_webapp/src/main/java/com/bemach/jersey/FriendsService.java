package com.bemach.jersey;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/friends-svc")
public class FriendsService {
	@GET
	@Produces({ "application/json" })
	/**
	 * This get method receives an input String and return a Greeting
	 * structure. Note that you need to have a 'generic' Response 
	 * return type.
	 * 
	 * @param userName
	 * @return
	 */
	@Path("/get")
	public Response get(@Context HttpHeaders hh) {
		MultivaluedMap<String, String> hdrs = hh.getRequestHeaders();
		System.out.println("Printing headers");

		for (String key : hdrs.keySet()) {
			System.out.println(String.format("%s=%s", key, hdrs.get(key)));
		}

		IFriendsDao friendsDao = FriendsDaoImpl.getInstance();
		Friend[] friends = friendsDao.getFriends();
		return Response.ok(friends).build();
	}

	@POST
	@Produces({ "application/json" })
	@Path("/add/{friendname}")
	public Response addFriend(@PathParam("friendname") String friendName,
			@Context HttpHeaders hh) {
		MultivaluedMap<String, String> hdrs = hh.getRequestHeaders();
		System.out.println("friendname="+friendName);
		System.out.println("Printing headers");
		for (String key : hdrs.keySet()) {
			System.out.println(String.format("%s=%s", key, hdrs.get(key)));
		}
		IFriendsDao friendsDao = FriendsDaoImpl.getInstance();
		friendsDao.addFriend(friendName);
		return Response.ok(true).build();
	}

	@DELETE
	@Produces({ "application/json" })
	@Path("/delete/{friendname}")
	public Response removeFriend(@PathParam("friendname") String friendName,
			@Context HttpHeaders hh) {
		MultivaluedMap<String, String> hdrs = hh.getRequestHeaders();
		System.out.println("friendname="+friendName);
		System.out.println("Printing headers");
		for (String key : hdrs.keySet()) {
			System.out.println(String.format("%s=%s", key, hdrs.get(key)));
		}
		IFriendsDao friendsDao = FriendsDaoImpl.getInstance();
		friendsDao.removeFriend(friendName);
		return Response.ok(true).build();
	}
}
