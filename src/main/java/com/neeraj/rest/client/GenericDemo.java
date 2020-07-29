package com.neeraj.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.neeraj.messenger.model.Message;

public class GenericDemo {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		// If you want to get all messages instead of just a single message, you need to handle the generic type.
		List<Message> messages = client.target("http://localhost:8080/advanced-jaxrs/webapi/")
				.path("messages")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Message>>() { });
		
		for(Message msg:messages) {
			System.out.println(msg.getMessage());	
		}
	}
}
