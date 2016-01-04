package com.itsbeenages.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by pgandhi on 1/4/16.
 */
@Path("/example")
public class ExampleResource {

  @GET
  @Path("/test")
  public String exampleGet() {
    return "Hello, world!";
  }

}
