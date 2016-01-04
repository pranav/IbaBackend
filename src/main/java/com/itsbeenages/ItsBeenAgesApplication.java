package com.itsbeenages;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by pgandhi on 1/4/16.
 */
public class ItsBeenAgesApplication extends Application<ItsBeenAgesConfiguration> {

  public static void main(String[] args) throws Exception {
    new ItsBeenAgesApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<ItsBeenAgesConfiguration> bootstrap) {
    GuiceBundle<ItsBeenAgesConfiguration> guiceBundle = GuiceBundle.<ItsBeenAgesConfiguration>newBuilder()
        .addModule(new ItsBeenAgesModule())
        .enableAutoConfig(getClass().getPackage().getName())
        .setConfigClass(ItsBeenAgesConfiguration.class)
        .build();

    bootstrap.addBundle(guiceBundle);
  }


  @Override
  public String getName() {
    return "ItsBeenAges";
  }

  @Override
  public void run(ItsBeenAgesConfiguration itsBeenAgesConfiguration, Environment environment) throws Exception {}


}
