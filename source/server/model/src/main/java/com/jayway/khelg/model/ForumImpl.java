package com.jayway.khelg.model;

import java.util.Collection;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.storage.TopicRepository;

@PersistenceCapable
public class ForumImpl implements Forum {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    @Persistent
    private String name;
    @NotPersistent
    private TopicRepository topicRepository;

    public ForumImpl(String name) {
        this.name = name;
    }

    public ForumImpl(long id, String name) {
        this(name);
        this.id = id;
    }

    public ForumImpl(TopicRepository topicRepository, long id, String name) {
        this(id, name);
        this.topicRepository = topicRepository;
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
        return topicRepository.getAllForForum(id);
    }

    public void addTopic(TopicImpl topic) {
        topicRepository.add(topic);
    }

    public void setTopicRepository(TopicRepository repo) {
        this.topicRepository = repo;
    }

}
