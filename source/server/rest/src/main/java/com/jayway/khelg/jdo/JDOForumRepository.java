package com.jayway.khelg.jdo;

import java.util.ArrayList;
import java.util.Collection;

import javax.jdo.Extent;
import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.JdoCallback;
import org.springframework.orm.jdo.JdoTemplate;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.storage.ForumRepository;

public class JDOForumRepository implements ForumRepository {

    @Autowired
    JdoTemplate jdoTemplate;

    @Override
    public Collection<Forum> getAll() {

        return jdoTemplate.execute(new JdoCallback<Collection<Forum>>() {

            @Override
            public Collection<Forum> doInJdo(PersistenceManager pm) throws JDOException {
                Collection<Forum> forums = new ArrayList<Forum>();

                Extent<ForumImpl> extent = pm.getExtent(ForumImpl.class);

                for (ForumImpl forum : extent) {
                    forums.add(forum);
                }
                return forums;
            }
        });
    }
}
