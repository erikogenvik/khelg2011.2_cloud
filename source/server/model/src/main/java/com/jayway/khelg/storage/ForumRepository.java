package com.jayway.khelg.storage;

import java.util.Collection;

import com.jayway.khelg.domain.Forum;

public interface ForumRepository {

    Collection<Forum> getAll();

    Forum add(Forum item);

    Forum get(long id);
    
}
