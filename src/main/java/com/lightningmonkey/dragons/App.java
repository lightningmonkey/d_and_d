package com.lightningmonkey.dragons;

import com.lightningmonkey.dragons.resources.CharacterResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<DragonsConfiguration>{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<DragonsConfiguration> b){}

    @Override
    public void run(DragonsConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method APP#run() called");
        System.out.println("Hello world from dropwizard");
        environment.jersey().register(new CharacterResource(environment.getValidator()));
    }
}
