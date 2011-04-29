package com.jayway.khelg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jayway.khelg.model.EntryImpl;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.model.TopicImpl;
import com.jayway.khelg.storage.ForumRepository;

@Component
@Path("/setup")
public class SetupResource {

    @Autowired
    private ForumRepository forumRepository;

    @GET
    @Path("forums")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public Response setupForums() {

        ForumImpl forum = new ForumImpl("Cars");
        TopicImpl topic = new TopicImpl("Welcome!");
        topic.addEntry(new EntryImpl("Welcome!", "Welcome to the cars forum."));
        forum.addTopic(topic);
        forumRepository.add(forum);
        // forumRepository.add(new ForumImpl("Guns"));
        // forumRepository.add(new ForumImpl("Houses"));
        // forumRepository.add(new ForumImpl("Cats"));

        return Response.ok("Created forums.").build();
    }
}
