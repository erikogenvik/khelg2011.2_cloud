package com.jayway.khelg.jdo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jdo.JdoCallback;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.model.TopicImpl;
import com.jayway.khelg.storage.EntryRepository;
import com.jayway.khelg.storage.TopicRepository;

public class JDOTopicRepository implements TopicRepository {
    
    @Autowired
    JdoTemplate jdoTemplate;

    @Autowired
    EntryRepository entityRepository;

    @Override
    @Transactional
    public Collection<Topic> getAll() {
        return jdoTemplate.execute(new JdoCallback<Collection<Topic>>() {

            @Override
            public Collection<Topic> doInJdo(PersistenceManager pm) throws JDOException {
                Collection<Topic> items = new ArrayList<Topic>();

                Extent<TopicImpl> extent = pm.getExtent(TopicImpl.class);

                for (TopicImpl item : extent) {
                    item.setEntryRepository(entityRepository);
                    items.add(item);
                }
                return items;
            }
        });
    }

    @Override
    @Transactional
    public void add(final Topic item) {
        jdoTemplate.execute(new JdoCallback<Void>() {

            @Override
            public Void doInJdo(PersistenceManager pm) throws JDOException {
                pm.makePersistent(item);
                return null;
            }
        });
    }

    @Override
    @Transactional
    public Topic get(final long id) {
        return jdoTemplate.execute(new JdoCallback<Topic>() {

            @Override
            public Topic doInJdo(PersistenceManager pm) throws JDOException {
                TopicImpl item = pm.getObjectById(TopicImpl.class, id);
                if (item != null) {
                    item.setEntryRepository(entityRepository);
                }
                return item;
            }
        });
    }

    @Override
    public Collection<? extends Topic> getAllForForum(final Long id) {
        return jdoTemplate.execute(new JdoCallback<Collection<? extends Topic>>() {

            @Override
            public Collection<? extends Topic> doInJdo(PersistenceManager pm) throws JDOException {

                Query query = pm.newQuery(TopicImpl.class, "forumId == forumIdParam");
                query.declareParameters("Long forumIdParam");
                @SuppressWarnings("unchecked")
                List<TopicImpl> items = (List<TopicImpl>) query.execute(id);

                for (TopicImpl item : items) {
                    item.setEntryRepository(entityRepository);
                }
                return items;
            }
        });
    }

    @Override
    public void addForForum(Long id, TopicImpl topic) {
        // TODO Auto-generated method stub

    }

}
