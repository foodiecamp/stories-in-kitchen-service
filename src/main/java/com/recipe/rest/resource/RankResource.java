/*************************************************************************
 * Copyright (c) Metabiota Incorporated - All Rights Reserved
 * ------------------------------------------------------------------------
 * This material is proprietary to Metabiota Incorporated. The
 * intellectual and technical concepts contained herein are proprietary
 * to Metabiota Incorporated. Reproduction or distribution of this
 * material, in whole or in part, is strictly forbidden unless prior
 * written permission is obtained from Metabiota Incorporated.
 * ***********************************************************************
 * <p/>
 * Created by WLao on 10/16/16.
 */
package com.recipe.rest.resource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.recipe.rest.dto.Rank;
import com.recipe.rest.service.rank.RankService;
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
@Path("ranks")
//public class RankResource {
//
//    @GET
//    @Produces("text/plain")
//    public String get() throws Exception {
//        return "welcome to Recipe! ";
//    }
//}

public class RankResource {
    @Autowired
    private RankService rankService;

    @GET
    @JacksonFeatures(serializationEnable = SerializationFeature.WRAP_ROOT_VALUE,
            deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    @Path("{id}")

    public Rank getById(@PathParam("id") Integer id) throws Exception {
        return rankService.findById(id);
    }



    @GET
    public Map<String, List<Rank>> getAll() throws Exception {
        return rankService.findAll();
    }

    @POST
    @JacksonFeatures(serializationEnable = SerializationFeature.WRAP_ROOT_VALUE,
            deserializationEnable = DeserializationFeature.UNWRAP_ROOT_VALUE)
    public Rank create(Rank rankDTO) throws Exception {
        return rankService.add(rankDTO);
    }

//    @PUT
//    @Path("{id}")
//    public void update(@PathParam("id") Integer itemId, Recipe recipeDTO) throws Exception {
//        recipeService.update(itemId, recipeDTO);
//    }

//    @DELETE
//    @Path("{id}")
//    public void delete(@PathParam("id") Integer itemId) throws Exception {
//        rankService.delete(itemId);
//    }
}
