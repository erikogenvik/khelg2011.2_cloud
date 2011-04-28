package com.jayway.khelg.rest;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.khelg.domain.Forum;
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
    public Response addForum() {
        throw new RuntimeException("add forum not implemented");
    }

    @GET
    @Path("/{id}")
    public Response forum(@PathParam("id") String id) {
        throw new RuntimeException("get by id not implemented");
    }

}
