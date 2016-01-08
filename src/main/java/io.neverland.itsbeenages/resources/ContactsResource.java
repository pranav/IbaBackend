package io.neverland.itsbeenages.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pgandhi on 1/8/16.
 */
@Path("/contacts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {

  @GET
  @Path("/{contactId}")
  public Map<String, String> getContact(@PathParam("contactId") long contactId) {
    Map<String, String> contact = new HashMap<String, String>(1);
    contact.put("name", "Pranav");
    return contact;
  }
}
