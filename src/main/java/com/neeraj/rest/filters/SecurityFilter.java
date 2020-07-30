package com.neeraj.rest.filters;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secured";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
			List<String> authHeaders = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if(authHeaders != null && authHeaders.size() > 0) {
				String authToken = authHeaders.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = new String(Base64.getDecoder().decode(authToken));
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String userName = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if("user".equals(userName) && "password".equals(password)) {
					return;
				}
			}
			
			Response resp = Response
					.status(Status.UNAUTHORIZED)
					.entity("User cannot access the resource")
					.build();
			requestContext.abortWith(resp);
		}
	}

}
