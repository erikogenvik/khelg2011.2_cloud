package com.jayway.khelg.storage;

import java.util.Collection;

import com.jayway.khelg.domain.Topic;

public interface TopicRepository {
    Collection<Topic> getAll();

    Topic add(Topic item);

    Topic get(long id);

    Collection<? extends Topic> getAllForForum(Long id);

    void addForForum(Long id, Topic topic);

}
