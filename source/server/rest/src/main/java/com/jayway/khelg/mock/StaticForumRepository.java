package com.jayway.khelg.mock;

import java.util.ArrayList;
import java.util.Collection;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.storage.ForumRepository;

public class StaticForumRepository implements ForumRepository {

    private Collection<Forum> forums = new ArrayList<Forum>();

    public StaticForumRepository() {
        forums.add(new ForumImpl(1, "Cars"));
        forums.add(new ForumImpl(2, "Guns"));
        forums.add(new ForumImpl(3, "Houses"));
        forums.add(new ForumImpl(4, "Cats"));
    }

    @Override
    public Collection<Forum> getAll() {
        return forums;
    }

}
