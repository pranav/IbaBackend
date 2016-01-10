package io.neverland.itsbeenages;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import io.neverland.itsbeenages.dao.ContactDao;
import io.neverland.itsbeenages.dao.UserContactDao;
import io.neverland.itsbeenages.dao.UserDao;
import org.skife.jdbi.v2.DBI;

public class ItsBeenAgesModule extends AbstractModule {
  @Override
  protected void configure() {
  }

  @Provides
  public ContactDao provideContactDao(DBI dbi) {
    return dbi.onDemand(ContactDao.class);
  }

  @Provides
  public UserDao provideUserDao(DBI dbi) {
    return dbi.onDemand(UserDao.class);
  }

  @Provides
  public UserContactDao provideUserContactDao(DBI dbi) {
    return dbi.onDemand(UserContactDao.class);
  }

  @Provides
  @Singleton
  public DBI provideDbi(ItsBeenAgesConfiguration configuration, Environment environment) {
    final DBI dbi = new DBIFactory().build(environment, configuration.getDataSourceFactory(), "mysql");
    dbi.registerMapper(new RosettaMapperFactory());
    return dbi;
  }

}
