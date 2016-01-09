package io.neverland.itsbeenages.dao;

import com.hubspot.rosetta.jdbi.BindWithRosetta;
import io.neverland.itsbeenages.model.Contact;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.unstable.BindIn;

import java.util.Set;


public interface ContactDao {
  @SqlQuery("SELECT * FROM contact WHERE id = :id")
  Contact findById(@Bind("id") long id);

  @SqlQuery("SELECT * FROM contact WHERE id IN (<ids>)")
  Set<Contact> findByIds(@BindIn("ids") Set<Long> ids);


  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO contact (firstName, lastName, visitFrequencySeconds) VALUES (:firstName, :lastName, :visitFrequencySeconds)")
  long insert(@BindWithRosetta Contact contact);

  @SqlUpdate("DELETE FROM contact WHERE id = :id")
  void delete(@Bind("id") long id);
}
