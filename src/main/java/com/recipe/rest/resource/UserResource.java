/**
 * Created by Wo Chio Lao on 10/09/2016
 */
package com.recipe.rest.resource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.recipe.rest.dto.User;
import com.recipe.rest.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Slf4j
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Resource
@Path("users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GET
    @JacksonFeatures(serializationEnable = SerializationFeature.WRAP_ROOT_VALUE,
            deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    @Path("{id}")
    public User getById(@PathParam("id") Integer id) throws Exception {
        return userService.findById(id);
    }

    @GET
    public Map<String, List<User>> getAll() throws Exception {
        return userService.findAll();
    }

    @POST
    @JacksonFeatures(serializationEnable = SerializationFeature.WRAP_ROOT_VALUE,
            deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    public User create(User userDTO) throws Exception {
        return userService.add(userDTO);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") Integer itemId, User userDTO) throws Exception {
        userService.update(itemId, userDTO);
    }

//    @DELETE
//    @Path("{id}")
//    public void delete(@PathParam("id") Integer itemId) throws Exception {
//        userService.delete(itemId);
//    }
}
