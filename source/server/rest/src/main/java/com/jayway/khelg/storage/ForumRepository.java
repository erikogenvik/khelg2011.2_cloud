package com.jayway.khelg.storage;

import java.util.Collection;

import com.jayway.khelg.domain.Forum;

public interface ForumRepository {

    Collection<Forum> getAll();

    void add(Forum forum);

    Forum get(long id);
    
}
