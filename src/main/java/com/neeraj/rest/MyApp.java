package com.neeraj.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// `@ApplicationPath` defines the relative base URL path for all of our JAX-RS services 
@ApplicationPath("webapi")
public class MyApp extends Application{

}
