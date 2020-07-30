package com.neeraj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecuredResource {
	
	@GET
	@Path("message")
	@Produces(MediaType.APPLICATION_JSON)
	public String secureMethod() {
		return "This is a secure resource";
	}

}
