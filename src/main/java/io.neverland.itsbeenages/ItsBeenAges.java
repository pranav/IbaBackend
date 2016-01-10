package io.neverland.itsbeenages;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.netflix.governator.guice.LifecycleInjector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ItsBeenAges extends Application<ItsBeenAgesConfiguration> {

  public static void main(String[] args) throws Exception {
    new ItsBeenAges().run(args);
  }

  @Override
  public void initialize(Bootstrap<ItsBeenAgesConfiguration> bootstrap) {
    bootstrap.addBundle(GuiceBundle.<ItsBeenAgesConfiguration>newBuilder()
        .addModule(new ItsBeenAgesModule())
        .enableAutoConfig(getClass().getPackage().getName())
        .setConfigClass(ItsBeenAgesConfiguration.class)
        .setInjectorFactory((stage, modules) -> LifecycleInjector.builder()
            .inStage(Stage.DEVELOPMENT)
            .withModules(modules)
            .build()
            .createInjector())
        .build());
  }

  @Override
  public void run(ItsBeenAgesConfiguration itsBeenAgesConfiguration, Environment environment) throws Exception {
  }
}
