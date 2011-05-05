package com.jayway.khelg.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.rest.dto.ForumDTO;
import com.jayway.khelg.rest.dto.TopicDTO;
import com.jayway.khelg.storage.ForumRepository;

@Component
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ForumResource {

    @Autowired
    private ForumRepository forumRepository;

    @GET
    public Collection<ForumDTO> listForums(@Context UriInfo uriInfo) {
        Collection<Forum> forums = forumRepository.getAll();
        return DTOTranslator.translateForumsToDTO(uriInfo, forums);
    }

    @POST
    public Response addForum(@QueryParam(value = "name") String name) {
        Forum forum = new ForumImpl(name);
        forumRepository.add(forum);
        return Response.ok("Added forum").build();
    }

    @GET
    @Path("/{id}")
    public ForumDTO get(@Context UriInfo uriInfo,@PathParam("id") long id) {
        return DTOTranslator.translateForumToDTO(uriInfo, forumRepository.get(id));
    }

    @GET
    @Path("/{forumid}/topics")
    @Transactional
    public Collection<TopicDTO> listTopics(@Context UriInfo uriInfo, @PathParam("forumid") long forumid) {
        Forum forum = forumRepository.get(forumid);
        return DTOTranslator.translateTopicsToDTO(uriInfo, forum.getTopics());
    }

}
