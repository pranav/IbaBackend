package io.neverland.itsbeenages;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by pgandhi on 1/8/16.
 */
public class ItsBeenAges extends Application<ItsBeenAgesConfiguration> {

  private GuiceBundle<ItsBeenAgesConfiguration> guiceBundle;

  public static void main(String[] args) throws Exception {
    new ItsBeenAges().run(args);
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
  public void run(ItsBeenAgesConfiguration itsBeenAgesConfiguration, Environment environment) throws Exception {

  }
}
