package com.jayway.khelg.rest.dto;

import java.net.URI;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Represents a link to a resource.
 * 
 * @author Erik Hjortsberg
 * 
 */
@XmlRootElement(name = "link")
public class LinkDTO {

    /**
     * The link to the resource.
     */
    public URI href;

    /**
     * The type of resource which the link points to.
     * 
     * This is in the form of an URN.
     */
    public String rel;

    /**
	 * 
	 */
    public LinkDTO() {
    }

    /**
     * Ctor.
     * 
     * @param href The URI used pointing to a resource.
     * @param rel The type of resource, specified as an URN.
     */
    public LinkDTO(URI href, String rel) {
        this.href = href;
        this.rel = rel;
    }
}
