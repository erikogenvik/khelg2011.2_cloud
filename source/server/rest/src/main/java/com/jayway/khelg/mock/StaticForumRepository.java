package com.jayway.khelg.mock;

import java.util.ArrayList;
import java.util.Collection;

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

    @Override
    public Collection<Forum> getAll() {
        return forums;
    }

    @Override
    public Forum add(Forum forum) {
        Forum newForum = new ForumImpl(topicRepository, forums.size() + 1, forum.getName());
        forums.add(newForum);
        return newForum;
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
