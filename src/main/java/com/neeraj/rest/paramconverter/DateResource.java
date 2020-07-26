package com.neeraj.rest.paramconverter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateParam}")
public class DateResource {
	
	/**
	 * Request: GET http://localhost:8080/advanced-jaxrs/webapi/date/yesterday
	 * Response: Got MyDate [day=26, month=6, year=2020]
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestMethod(@PathParam("dateParam") MyDate date) {
		return "Got " + date;
	}

}
