package com.jayway.khelg.storage;

import java.util.Collection;

import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.model.TopicImpl;

public interface TopicRepository {
    Collection<Topic> getAll();

    void add(Topic item);

    Topic get(long id);

    Collection<? extends Topic> getAllForForum(Long id);

    void addForForum(Long id, TopicImpl topic);

}
