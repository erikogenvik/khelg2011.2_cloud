package com.jayway.khelg.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.rest.dto.ForumDTO;
import com.jayway.khelg.storage.ForumRepository;

@Component
@Path("/")
public class ForumResource {

    @Autowired
    private ForumRepository forumRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ForumDTO> listForums() {
        Collection<Forum> forums = forumRepository.getAll();
        return translateToDTO(forums);
    }

    private Collection<ForumDTO> translateToDTO(Collection<Forum> forums) {
        Collection<ForumDTO> dtos = new ArrayList<ForumDTO>();
        for (Forum forum : forums) {
            ForumDTO dto = new ForumDTO();
            dto.id = forum.getId();
            dto.name = forum.getName();
            dtos.add(dto);
        }
        return dtos;
    }

    @POST
    public Response addForum(@QueryParam(value = "name") String name) {
        Forum forum = new ForumImpl(name);
        forumRepository.add(forum);
        return Response.ok("Added forum").build();
    }

    @GET
    @Path("/{id}")
    public ForumDTO forum(@PathParam("id") long id) {
        Forum forum = forumRepository.get(id);
        ForumDTO dto = new ForumDTO();
        dto.id = forum.getId();
        dto.name = forum.getName();
        return dto;
    }

}
