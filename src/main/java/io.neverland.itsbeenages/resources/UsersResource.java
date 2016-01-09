package io.neverland.itsbeenages.resources;

import io.neverland.itsbeenages.dao.ContactDao;
import io.neverland.itsbeenages.dao.UserContactDao;
import io.neverland.itsbeenages.dao.UserDao;
import io.neverland.itsbeenages.model.Contact;
import io.neverland.itsbeenages.model.User;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {
  private final UserDao userDao;
  private final UserContactDao userContactDao;
  private final ContactDao contactDao;

  @Inject
  public UsersResource(UserDao userDao,
                       UserContactDao userContactDao,
                       ContactDao contactDao) {
    this.userDao = userDao;
    this.userContactDao = userContactDao;
    this.contactDao = contactDao;
  }

  @GET
  @Path("/{phoneNumber}")
  public User getUserByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
    return userDao.findByPhoneNumber(phoneNumber);
  }

  @POST
  public User createUser(@Valid User user) {
    return userDao.findById(userDao.createUser(user));
  }

  @POST
  @Path("/{userId}/associateContacts")
  public void associateContacts(@PathParam("userId") long userId, Set<Long> contactIds) {
    contactIds
        .stream()
        .forEach(contactId -> userContactDao.insertUserContact(userId, contactId));
  }

  @GET
  @Path("/{id}/contacts")
  public Set<Contact> getUserContacts(@PathParam("id") long id) {
    return contactDao.findByIds(userContactDao.findUserContactsIds(id));
  }
}
