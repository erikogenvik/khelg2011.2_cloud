package com.jayway.khelg.mock;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.NotImplementedException;

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.model.EntryImpl;
import com.jayway.khelg.storage.EntryRepository;

public class StaticEntryRepository implements EntryRepository {

    private Collection<Entry> entries = new ArrayList<Entry>();

    public StaticEntryRepository() {
    }

    @PostConstruct
    public void setup() {
        entries.add(new EntryImpl(1, 1, "Welcome to Cars", "Some text about cars."));
        entries.add(new EntryImpl(2, 2, "Welcome to Guns", "Some text about guns."));
        entries.add(new EntryImpl(3, 3, "Welcome to Houses", "Some text about houses."));
        entries.add(new EntryImpl(4, 4, "Welcome to Cats", "Some text about cats."));
    }

    @Override
    public Collection<Entry> getAll() {
        return entries;
    }

    @Override
    public void add(Entry item) {
        entries.add(item);
    }

    @Override
    public Entry get(long id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Collection<? extends Entry> getAllForTopic(Long id) {
        Collection<Entry> matchingEntries = new ArrayList<Entry>();
        for (Entry entry : entries) {
            if (entry.getTopicId() == id) {
                matchingEntries.add(entry);
            }
        }
        return matchingEntries;
    }

    @Override
    public void addForTopic(Long id, Entry entry) {
        throw new NotImplementedException();
    }

}
