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

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.model.EntryImpl;
import com.jayway.khelg.storage.EntryRepository;

public class JDOEntryRepository implements EntryRepository {
    @Autowired
    JdoTemplate jdoTemplate;

    @Override
    @Transactional
    public Collection<Entry> getAll() {
        return jdoTemplate.execute(new JdoCallback<Collection<Entry>>() {

            @Override
            public Collection<Entry> doInJdo(PersistenceManager pm) throws JDOException {
                Collection<Entry> items = new ArrayList<Entry>();

                Extent<EntryImpl> extent = pm.getExtent(EntryImpl.class);

                for (EntryImpl item : extent) {
                    items.add(item);
                }
                return items;
            }
        });
    }

    @Override
    @Transactional
    public Entry add(final Entry item) {
        return jdoTemplate.execute(new JdoCallback<Entry>() {

            @Override
            public Entry doInJdo(PersistenceManager pm) throws JDOException {
                pm.makePersistent(item);
                return item;
            }
        });
    }

    @Override
    @Transactional
    public Entry get(final long id) {
        return jdoTemplate.execute(new JdoCallback<Entry>() {

            @Override
            public Entry doInJdo(PersistenceManager pm) throws JDOException {
                return pm.getObjectById(EntryImpl.class, id);
            }
        });
    }

    @Override
    public Collection<? extends Entry> getAllForTopic(final Long id) {
        return jdoTemplate.execute(new JdoCallback<Collection<? extends Entry>>() {

            @Override
            public Collection<? extends Entry> doInJdo(PersistenceManager pm) throws JDOException {

                Query query = pm.newQuery(EntryImpl.class, "topicId == topicIdParam");
                query.declareParameters("Long topicIdParam");
                @SuppressWarnings("unchecked")
                List<EntryImpl> items = (List<EntryImpl>) query.execute(id);
                return items;
            }
        });
    }

    @Override
    public void addForTopic(Long id, Entry entry) {
        // TODO Auto-generated method stub

    }

}
