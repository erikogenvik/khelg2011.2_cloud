package com.jayway.khelg.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.model.TopicImpl;
import com.jayway.khelg.storage.EntryRepository;
import com.jayway.khelg.storage.TopicRepository;

public class StaticTopicRepository implements TopicRepository {

    @Autowired
    private EntryRepository entryRepository;

    private Collection<Topic> topics = new ArrayList<Topic>();

    public StaticTopicRepository() {
    }

    @Override
    public Collection<Topic> getAll() {
        return topics;
    }

    @Override
    public Topic add(Topic item) {
        Topic newItem = new TopicImpl(entryRepository, topics.size() + 1, item.getForumId(), item.getHeader());
        topics.add(newItem);
        return newItem;
    }

    @Override
    public Topic get(long id) {
        for (Topic topic : topics) {
            if (topic.getId() == id) {
                return topic;
            }
        }
        return null;
    }

    @Override
    public Collection<? extends Topic> getAllForForum(Long id) {
        Collection<Topic> matchingTopics = new ArrayList<Topic>();
        for (Topic topic : topics) {
            if (topic.getForumId() == id) {
                matchingTopics.add(topic);
            }
        }
        return matchingTopics;
    }

    @Override
    public void addForForum(Long id, Topic topic) {
        throw new NotImplementedException();
    }

}
