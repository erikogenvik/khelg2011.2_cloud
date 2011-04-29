package com.jayway.khelg.model;

import java.util.Collection;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.domain.Topic;

@PersistenceCapable
public class ForumImpl implements Forum {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    @Persistent
    private String name;
    @Persistent
    private Collection<TopicImpl> topics;

    public ForumImpl(String name) {
        this.name = name;
    }

    public ForumImpl(long id, String name) {
        this(name);
        this.id = id;
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
    public Collection<? extends Topic> getTopics() {
        return topics;
    }

}
