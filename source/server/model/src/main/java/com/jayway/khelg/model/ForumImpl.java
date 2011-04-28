package com.jayway.khelg.model;

import java.util.Collection;

import javax.jdo.annotations.PersistenceCapable;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.domain.Topic;

@PersistenceCapable
public class ForumImpl implements Forum {

    private long id;
    private String name;
    private Collection<Topic> topics;

    public ForumImpl(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Topic> getTopics() {
        return topics;
    }

}
