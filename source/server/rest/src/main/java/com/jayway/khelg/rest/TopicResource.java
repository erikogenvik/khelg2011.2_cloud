package com.jayway.khelg.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jayway.khelg.rest.dto.EntryDTO;
import com.jayway.khelg.rest.dto.TopicDTO;
import com.jayway.khelg.storage.TopicRepository;

@Component
@Path("/topic")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {

    @Autowired
    private TopicRepository topicRepository;

    @GET
    @Path("/{id}")
    @Transactional
    public TopicDTO get(@Context UriInfo uriInfo, @PathParam("id") long id) {
        return DTOTranslator.translateTopicToDTO(uriInfo, topicRepository.get(id));

    }

    @GET
    @Path("/{topicid}/entries")
    @Transactional
    public Collection<EntryDTO> getEntries(@Context UriInfo uriInfo, @PathParam("topicid") long topicid) {
        return DTOTranslator.translateEntriesToDTO(uriInfo, topicRepository.get(topicid).getEntries());

    }

}
