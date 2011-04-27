package com.jayway.khelg.domain;

/**
 * Interface for any domain object which uses a numeric id.
 * 
 * @author Erik Hjortsberg
 * 
 */
public interface Identifiable {
    
    /**
     * 
     * @return the numeric id of the data object.
     */
    long getId();
}
