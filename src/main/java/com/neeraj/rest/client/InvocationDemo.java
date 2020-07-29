package com.neeraj.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		InvocationDemo invocationDemo = new InvocationDemo();
		Response resp = invocationDemo.prepareReqForMessagesByYear(2020).invoke(); //Invoke the request
		System.out.println(resp.getStatus());

	}
	
	public Invocation prepareReqForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();

		// Just prepare the request; Don't call it yet!
		return client.target("http://localhost:8080/advanced-jaxrs/webapi/")
				.path("messages")
				.queryParam("year", year)
				.request()
				.buildGet();
	}

}
