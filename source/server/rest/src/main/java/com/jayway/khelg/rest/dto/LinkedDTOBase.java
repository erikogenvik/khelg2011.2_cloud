package com.jayway.khelg.rest.dto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Base of all resources which presents links to other resources.
 * 
 * @author Erik Hjortsberg
 * 
 */
@XmlRootElement
public class LinkedDTOBase {

    /**
     * A list of links leading to other resources.
     */
    public List<LinkDTO> links;

    /**
     * Ctor.
     */
    public LinkedDTOBase() {
        links = new ArrayList<LinkDTO>();
    }

    /**
     * Creates and adds a new link to the list of links.
     * 
     * @param href
     *            The URI for the link.
     * @param rel
     *            The type of the link.
     * @return The new link instance.
     */
    public LinkDTO addLink(URI href, String rel) {
        LinkDTO link = new LinkDTO(href, rel);
        links.add(link);
        return link;
    }

    /**
     * Creates and adds a new link to the list of links.
     * 
     * @param uriInfo
     *            The URI info context for the current request.
     * @param clazz
     *            The class to get a link to.
     * @param rel
     *            The type of the link.
     * @return The new link instance.
     */
    public LinkDTO addLink(UriInfo uriInfo, Class<?> clazz, String rel) {
        return addLink(UriBuilder.fromUri(uriInfo.getAbsolutePath()).path(clazz).build(), rel);
    }

    /**
     * Creates and adds a new link to the list of links.
     * 
     * @param uriInfo
     *            The URI info context for the current request.
     * @param relativePath
     *            A path relative to the current request.
     * @param rel
     *            The type of the link.
     * @return The new link instance.
     */
    public LinkDTO addLink(UriInfo uriInfo, String relativePath, String rel) {
        return addLink(UriBuilder.fromUri(uriInfo.getAbsolutePath()).path(relativePath).build(), rel);
    }

}
