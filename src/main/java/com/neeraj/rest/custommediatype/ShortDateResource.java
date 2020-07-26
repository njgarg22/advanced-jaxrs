package com.neeraj.rest.custommediatype;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("shortdate")
public class ShortDateResource {

	@GET
	@Produces("text/shortdate")
	public Date getMethod() {		
		return Calendar.getInstance().getTime();
	}

}
