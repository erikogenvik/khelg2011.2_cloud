package com.jayway.khelg.domain;

import java.util.Collection;

public interface Forum extends Identifiable {

    /**
     * Gets the name of the forum, as a human readable string.
     * 
     * @return The name of the forum.
     */
    String getName();

    Collection<? extends Topic> getTopics();

}
