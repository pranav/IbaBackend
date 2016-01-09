package io.neverland.itsbeenages.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.Set;

public interface UserContactDao {
  @SqlQuery("SELECT contactId FROM user_contact WHERE userId = :userId")
  Set<Long> findUserContactsIds(@Bind("userId") long userId);

  @SqlUpdate("INSERT INTO user_contact (userId, contactId) VALUES (:userId, :contactId)")
  void insertUserContact(@Bind("userId") long userId, @Bind("contactId") long contactId);
}
