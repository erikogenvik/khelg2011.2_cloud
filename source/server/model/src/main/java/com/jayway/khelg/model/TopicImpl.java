package com.jayway.khelg.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.domain.Topic;

@PersistenceCapable
public class TopicImpl implements Topic {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String key;

    @Extension(vendorName = "datanucleus", key = "gae.pk-id", value = "true")
    private Long id;
    @Persistent
    private String header;
    @Persistent
    private List<EntryImpl> entries;

    public TopicImpl(String header) {
        this.header = header;
        this.entries = new ArrayList<EntryImpl>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public Collection<? extends Entry> getEntries() {
        return entries;
    }

    public void addEntry(EntryImpl entry) {
        entries.add(entry);

    }

}
