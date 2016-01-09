package io.neverland.itsbeenages;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;
import io.neverland.itsbeenages.dao.ContactDao;
import io.neverland.itsbeenages.dao.UserContactDao;
import io.neverland.itsbeenages.dao.UserDao;
import org.skife.jdbi.v2.DBI;

public class ItsBeenAgesModule extends AbstractModule {
  @Override
  protected void configure() {

  }

  @Provides
  @Singleton
  public ContactDao provideContactDao(DBI dbi) {
    return dbi.open(ContactDao.class);
  }

  @Provides
  @Singleton
  public UserDao provideUserDao(DBI dbi) {
    return dbi.open(UserDao.class);
  }

  @Provides
  @Singleton
  public UserContactDao provideUserContactDao(DBI dbi) {
    return dbi.open(UserContactDao.class);
  }

  @Provides
  @Singleton
  public DBI provideDbi() throws ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
    DBI dbi = new DBI("jdbc:mysql://db.neverland.io/ItsBeenAges?useSSL=false", "app", "3ycp7R6nHYKHZynzgfeNsJyls2lJN7v7");
    dbi.registerMapper(new RosettaMapperFactory());
    return dbi;
  }
}
