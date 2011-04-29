package com.jayway.khelg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.storage.ForumRepository;

@Component
@Path("/setup")
public class SetupResource {

    @Autowired
    private ForumRepository forumRepository;

    @GET
    @Path("forums")
    @Produces(MediaType.TEXT_PLAIN)
    public Response setupForums() {

        forumRepository.add(new ForumImpl("Cars"));
        forumRepository.add(new ForumImpl("Guns"));
        forumRepository.add(new ForumImpl("Houses"));
        forumRepository.add(new ForumImpl("Cats"));

        return Response.ok("Created forums.").build();
    }
}
