package io.neverland.itsbeenages.resources;

import com.google.inject.Inject;
import io.neverland.itsbeenages.dao.ContactDao;
import io.neverland.itsbeenages.model.Contact;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/contacts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {

  private final ContactDao contactDao;

  @Inject
  public ContactsResource(ContactDao contactDao) {
    this.contactDao = contactDao;
  }

  @GET
  @Path("/{id}")
  public Contact getContact(@PathParam("id") long id) {
    return contactDao.findById(id);
  }

  @POST
  public Contact createContact(@Valid Contact contact) {
    return contactDao.findById(contactDao.insert(contact));
  }

  @DELETE
  @Path("/{id}")
  public void deleteContact(@PathParam("id") long id) {
    contactDao.delete(id);
  }
}
