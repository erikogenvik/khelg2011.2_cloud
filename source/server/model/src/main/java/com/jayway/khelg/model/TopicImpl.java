package com.jayway.khelg.model;

import java.util.Collection;

import javax.jdo.annotations.PersistenceCapable;

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.domain.Topic;

@PersistenceCapable
public class TopicImpl implements Topic {

	private String header;
	private Collection<Entry> entries;

	@Override
	public String getHeader() {
		return header;
	}

	@Override
	public Collection<Entry> getEntries() {
		return entries;
	}

}
