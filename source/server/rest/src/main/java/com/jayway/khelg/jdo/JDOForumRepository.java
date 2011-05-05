package com.jayway.khelg.jdo;

import java.util.ArrayList;
import java.util.Collection;

import javax.jdo.Extent;
import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.JdoCallback;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.jayway.khelg.domain.Forum;
import com.jayway.khelg.model.ForumImpl;
import com.jayway.khelg.storage.ForumRepository;
import com.jayway.khelg.storage.TopicRepository;

public class JDOForumRepository implements ForumRepository {

    @Autowired
    JdoTemplate jdoTemplate;

    @Autowired
    TopicRepository topicRepository;

    @Override
    @Transactional
    public Collection<Forum> getAll() {

        return jdoTemplate.execute(new JdoCallback<Collection<Forum>>() {

            @Override
            public Collection<Forum> doInJdo(PersistenceManager pm) throws JDOException {
                Collection<Forum> forums = new ArrayList<Forum>();

                Extent<ForumImpl> extent = pm.getExtent(ForumImpl.class);

                for (ForumImpl forum : extent) {
                    forum.setTopicRepository(topicRepository);
                    forums.add(forum);
                }
                return forums;
            }
        });
    }

    @Override
    @Transactional
    public Forum add(final Forum forum) {
        return jdoTemplate.execute(new JdoCallback<Forum>() {

            @Override
            public Forum doInJdo(PersistenceManager pm) throws JDOException {
                pm.makePersistent(forum);
                return forum;
            }
        });

    }

    @Override
    @Transactional
    public Forum get(final long id) {
        return jdoTemplate.execute(new JdoCallback<Forum>() {

            @Override
            public Forum doInJdo(PersistenceManager pm) throws JDOException {
                ForumImpl forum = pm.getObjectById(ForumImpl.class, id);
                if (forum != null) {
                    forum.setTopicRepository(topicRepository);
                }
                return forum;
            }
        });
    }
}
