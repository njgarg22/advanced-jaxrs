package com.neeraj.rest.messagebodywriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider	// To tell JAX-RS that this is a deployable JAX-RS component.
@Produces(MediaType.TEXT_PLAIN)	// To tell JAX-RS which media types this MessageBodyWriter supports
public class DateMessageBodyWriter implements MessageBodyWriter<Date> {

	//This method is called by the JAX-RS runtime to determine if the writer supports marshaling the given type
	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Date.class.isAssignableFrom(type);
	}

	// Writes the contents out to the HTTP response buffer.
	@Override
	public void writeTo(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		entityStream.write(t.toString().getBytes());
	}
}
