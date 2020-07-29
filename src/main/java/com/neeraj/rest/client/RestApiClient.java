package com.neeraj.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.neeraj.messenger.model.Message;
import com.neeraj.messenger.model.Profile;

public class RestApiClient {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget  = client.target("http://localhost:8080/advanced-jaxrs/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMsgTarget = messagesTarget.path("{messageID}");
		
		Message msg1 = singleMsgTarget
				.resolveTemplate("messageID", "1")
				.request()
				.get(Message.class);
		
		Message msg2 = singleMsgTarget
				.resolveTemplate("messageID", "2")
				.request()
				.get(Message.class);
		
		System.out.println(msg1.getMessage());
		System.out.println(msg2.getMessage());

	}
	
}
