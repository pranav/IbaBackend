package io.neverland.itsbeenages.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Set;

public class UserContacts {
  @NotEmpty private final long userId;
  @NotEmpty private final Set<Long> contactIds;

  public UserContacts(long userId, Set<Long> contactId) {
    this.userId = userId;
    this.contactIds = contactId;
  }

  public long getUserId() {
    return userId;
  }

  public Set<Long> getContactIds() {
    return contactIds;
  }
}
