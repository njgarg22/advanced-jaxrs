package com.neeraj.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Annotating `@Singleton` will result in error: Parameter `pathStr` and `queryStr` cannot be injected into singleton resource.
 * As singleton resources are instantiated during application startup, so you can't inject request-specific info to their member variables.
 */
@Path("{pathParam}/test") // The `pathParam` in the `Path` annotation lets us map a resource to a variable path pattern.
public class PathParamResource {
	
	// Fields can be annotated with `@PathParam` as long as the resource class lifecycle is `per-request`.
	@PathParam("pathParam") private String pathStr;
	@QueryParam("query") private String queryStr;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "PathParam: " + pathStr + " QueryParam: " + queryStr;
	}
}
