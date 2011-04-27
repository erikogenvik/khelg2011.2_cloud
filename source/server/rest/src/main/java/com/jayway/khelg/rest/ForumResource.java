package com.jayway.khelg.rest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Path("/")
public class ForumResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listForums() {
        Map<String, String> sysinfo = new LinkedHashMap<String, String>();
        sysinfo.put("Current server date and time", new Date().toString());

        JSONObject json = new JSONObject();
        json.put("systeminfo", sysinfo);

        return Response.ok(json).build();
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
