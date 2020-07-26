package com.neeraj.rest.paramconverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 * ParamConverterProvider is basically a factory for ParamConverters.
 * It is the component that must be scanned or registered with your Application deployment class.
 */
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar requestedDate = Calendar.getInstance();
					if("tomorrow".equalsIgnoreCase(value)) {
						requestedDate.add(Calendar.DATE, 1);
					}else if("tomorrow".equalsIgnoreCase(value)) {
						requestedDate.add(Calendar.DATE, -1);
					}
					MyDate myDate = new MyDate();
					myDate.setDay(requestedDate.get(Calendar.DATE));
					myDate.setMonth(requestedDate.get(Calendar.MONTH));
					myDate.setYear(requestedDate.get(Calendar.YEAR));

					return rawType.cast(myDate);
				}

				@Override
				public String toString(Object value) {
					if(value == null) {
						return null;
					}
					return value.toString();
				}
				
			};
		}
		return null;
	}

}
