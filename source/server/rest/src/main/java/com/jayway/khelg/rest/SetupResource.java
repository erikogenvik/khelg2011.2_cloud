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
import com.jayway.khelg.storage.EntryRepository;
import com.jayway.khelg.storage.ForumRepository;
import com.jayway.khelg.storage.TopicRepository;

@Component
@Path("/setup")
public class SetupResource {

    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private EntryRepository entryRepository;

    @GET
    @Path("forums")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public Response setupForums() {

        ForumImpl forum = new ForumImpl("Cars");
        forum.setTopicRepository(topicRepository);
        forumRepository.add(forum);
        TopicImpl topic = new TopicImpl(forum.getId(), "Welcome!");
        topic.setEntryRepository(entryRepository);
        forum.addTopic(topic);
        topic.addEntry(new EntryImpl(topic.getId(), "Welcome!", "Welcome to the cars forum."));
        // forumRepository.add(new ForumImpl("Guns"));
        // forumRepository.add(new ForumImpl("Houses"));
        // forumRepository.add(new ForumImpl("Cats"));

        return Response.ok("Created forums.").build();
    }
}
