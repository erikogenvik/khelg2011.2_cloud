package com.jayway.khelg.domain;

import java.util.Collection;

public interface Forum {

	/**
	 * Gets the unique id of this forum.
	 * 
	 * @return The unique id of the forum.
	 */
	String getId();

	/**
	 * Gets the name of the forum, as a human readable string.
	 * 
	 * @return The name of the forum.
	 */
	String getName();
	
	
	Collection<Topic> getTopics();

}
