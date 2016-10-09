package com.recipe.rest.resource;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Wo Chio Lao on 10/09/2016
 */
@Resource
@Path("/")
public class SampleResource {

    @GET
    @Produces("text/plain")
    public String get() throws Exception {
        return "welcome to Recipe! ";
    }
}
