package com.jayway.khelg.model;

import java.util.Collection;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.domain.Topic;
import com.jayway.khelg.storage.EntryRepository;

@PersistenceCapable
public class TopicImpl implements Topic {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private long forumId;
    @Persistent
    private String header;

    @NotPersistent
    private EntryRepository entryRepository;

    public TopicImpl(long forumId, String header) {
        this.forumId = forumId;
        this.header = header;
    }

    public TopicImpl(long id, long forumId, String header) {
        this(forumId, header);
        this.id = id;
    }

    public TopicImpl(EntryRepository entryRepository, long id, long forumId, String header) {
        this(id, forumId, header);
        this.entryRepository = entryRepository;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getForumId() {
        return forumId;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public Collection<? extends Entry> getEntries() {
        return entryRepository.getAllForTopic(id);
    }

    public void addEntry(EntryImpl entry) {
        entryRepository.add(entry);
    }

    public void setEntryRepository(EntryRepository repo) {
        this.entryRepository = repo;
    }
}
