package com.jayway.khelg.domain;

import java.util.Collection;

public interface Topic {

	/**
	 * Gets the header of the topic.
	 * 
	 * @return
	 */
	String getHeader();

	Collection<Entry> getEntries();

}
