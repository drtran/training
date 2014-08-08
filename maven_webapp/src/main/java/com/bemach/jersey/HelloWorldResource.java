package com.bemach.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/helloworld/{username}")
public class HelloWorldResource {
	@GET
	@Produces({"application/json"})
	/**
	 * This get method receives an input String and return a Greeting
	 * structure. Note that you need to have a 'generic' Response 
	 * return type.
	 * 
	 * @param userName
	 * @return
	 */
	public Response get(@PathParam("username") String userName,
						@Context HttpHeaders hh) {
		MultivaluedMap<String,String> hdrs = hh.getRequestHeaders();
		System.out.println("Printing headers");
		for (String key: hdrs.keySet()) {
			System.out.println(String.format("%s=%s",key,hdrs.get(key)));
		}
		Greeting greeting = new Greeting();
		greeting.setMsg(String.format("Hello world %s!",userName));
		return Response.ok(greeting).build();
	}
}
