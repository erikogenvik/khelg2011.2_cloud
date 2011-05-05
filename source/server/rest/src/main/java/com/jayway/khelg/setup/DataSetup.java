package com.jayway.khelg.setup;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.model.EntryImpl;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.model.TopicImpl;
import com.jayway.khelg.storage.EntryRepository;
import com.jayway.khelg.storage.ForumRepository;
import com.jayway.khelg.storage.TopicRepository;

@Component
public class DataSetup {

    private static final Logger log = LoggerFactory.getLogger(DataSetup.class);
    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private TopicRepository topicRepository;

    @PostConstruct
    public void setup() {
        if (forumRepository.getAll().isEmpty()) {
            log.info("No data in repository, initiating with basic data.");
            Forum forum = forumRepository.add(new ForumImpl("Cars"));
            Topic topic = topicRepository.add(new TopicImpl(forum.getId(), "Welcome to Car"));
            entryRepository.add(new EntryImpl(topic.getId(), "Welcome to Cars", "Some text about cars."));

            forum = forumRepository.add(new ForumImpl("Guns"));
            topic = topicRepository.add(new TopicImpl(forum.getId(), "Welcome to Guns"));
            entryRepository.add(new EntryImpl(topic.getId(), "Welcome to Guns", "Some text about guns."));

            forum = forumRepository.add(new ForumImpl("Houses"));
            topic = topicRepository.add(new TopicImpl(forum.getId(), "Welcome to Houses"));
            entryRepository.add(new EntryImpl(topic.getId(), "Welcome to Houses", "Some text about houses."));

            forum = forumRepository.add(new ForumImpl("Cats"));
            topic = topicRepository.add(new TopicImpl(forum.getId(), "Welcome to Cats"));
            entryRepository.add(new EntryImpl(topic.getId(), "Welcome to Cats", "Some text about cats."));

            log.info("Data created.");

        }
    }
}
