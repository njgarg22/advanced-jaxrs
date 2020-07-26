package com.neeraj.rest.messagebodywriter;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("mydate")
public class MyResource {

	/**
	 * Without any MessageBodyWriter, we get the following error:
	 * 		SEVERE: MessageBodyWriter not found for media type=text/plain, type=class java.util.Date.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getMethod() {		
		return Calendar.getInstance().getTime();
	}

}

