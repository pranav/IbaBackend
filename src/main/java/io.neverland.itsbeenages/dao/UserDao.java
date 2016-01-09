package io.neverland.itsbeenages.dao;

import com.hubspot.rosetta.jdbi.BindWithRosetta;
import io.neverland.itsbeenages.model.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDao {
  @SqlQuery("SELECT * FROM user WHERE phoneNumber = :phoneNumber")
  User findByPhoneNumber(@Bind("phoneNumber") String phoneNumber);

  @SqlQuery("SELECT * FROM user WHERE id = :id")
  User findById(@Bind("id") long id);

  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO user (firstName, lastName, phoneNumber) VALUES (:firstName, :lastName, :phoneNumber)")
  long createUser(@BindWithRosetta User user);
}
