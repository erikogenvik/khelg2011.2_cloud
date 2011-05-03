package com.jayway.khelg.mock;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.storage.ForumRepository;
import com.jayway.khelg.storage.TopicRepository;

public class StaticForumRepository implements ForumRepository {

    @Autowired
    private TopicRepository topicRepository;

    private Collection<Forum> forums = new ArrayList<Forum>();

    public StaticForumRepository() {
    }
    
    @PostConstruct
    public void setup() {
        forums.add(new ForumImpl(topicRepository, 1, "Cars"));
        forums.add(new ForumImpl(topicRepository, 2, "Guns"));
        forums.add(new ForumImpl(topicRepository, 3, "Houses"));
        forums.add(new ForumImpl(topicRepository, 4, "Cats"));
    }

    @Override
    public Collection<Forum> getAll() {
        return forums;
    }

    @Override
    public void add(Forum forum) {
        forums.add(forum);
    }

    @Override
    public Forum get(long id) {
        for (Forum forum : forums) {
            if (forum.getId() == id) {
                return forum;
            }
        }
        return null;
    }

}
