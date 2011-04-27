package com.jayway.khelg.rest;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    public Response addForum() {
        throw new RuntimeException("not implemented");
    }

    public Response forum() {
        throw new RuntimeException("not implemented");
    }

}
