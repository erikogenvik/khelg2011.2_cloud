package com.jayway.khelg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jayway.khelg.rest.dto.EntryDTO;
import com.jayway.khelg.storage.EntryRepository;

@Component
@Path("/entry")
@Produces(MediaType.APPLICATION_JSON)
public class EntryResource {

    @Autowired
    EntryRepository entryRepository;

    @GET
    @Path("/{id}")
    @Transactional
    public EntryDTO get(@Context UriInfo uriInfo, @PathParam("id") long id) {
        return DTOTranslator.translateEntryToDTO(uriInfo, entryRepository.get(id));

    }

    @GET
    @Transactional
    public Response listEntries() {
        throw new RuntimeException("not implemented");
    }

    public Response addEntry() {
        throw new RuntimeException("not implemented");
    }

}
