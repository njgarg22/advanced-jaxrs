package com.neeraj.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


import com.neeraj.messenger.model.Message;

public class RestApiClient {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget  = client.target("http://localhost:8080/advanced-jaxrs/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMsgTarget = messagesTarget.path("{messageID}");
		
		Message msg1 = singleMsgTarget
				.resolveTemplate("messageID", "1")
				.request()
				.get(Message.class);	//GET baseUrl/messages/1
		
		Message msg2 = singleMsgTarget
				.resolveTemplate("messageID", "2")
				.request()
				.get(Message.class);	//GET baseUrl/messages/1
		
		Message newMessage = new Message(3, "Hello Rust", "Neeraj Garg");
		Response postResponse = messagesTarget.request().post(Entity.json(newMessage));	//POST baseUrl/messages
		System.out.println(msg1.getMessage());
		System.out.println(msg2.getMessage());
		System.out.println(postResponse.readEntity(Message.class).getMessage());

	}
	
}
