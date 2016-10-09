package com.recipe.rest;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by Wo Chio Lao on 10/09/2016
 */
public class RestApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public RestApplication() {
        packages("com.recipe.rest");
    }

}
