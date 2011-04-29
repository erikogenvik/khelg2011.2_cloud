package com.jayway.khelg.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private List<TopicImpl> topics;

    public ForumImpl(String name) {
        this.name = name;
        this.topics = new ArrayList<TopicImpl>();
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

    public void addTopic(TopicImpl topic) {
        topics.add(topic);
    }

}
