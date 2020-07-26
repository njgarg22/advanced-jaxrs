package com.neeraj.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * By default the life-cycle of root resource classes is `per-request`.
 * So, a new instance of a root resource class is created every time the request URI path matches the root resource.
 * 
 * For resources annotated with @Singleton, there is only one instance per jax-rs application.
 */
@Path("singleton")
@Singleton
public class SingletonResource {
	
	private int count;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		count++;
		
		return "this method is called " + count + " times";
	}
}
