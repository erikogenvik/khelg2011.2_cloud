package com.jayway.khelg.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.NotImplementedException;

import com.jayway.khelg.domain.Entry;
import com.jayway.khelg.model.EntryImpl;
import com.jayway.khelg.storage.EntryRepository;

public class StaticEntryRepository implements EntryRepository {

    private Collection<Entry> entries = new ArrayList<Entry>();

    public StaticEntryRepository() {
    }

    @Override
    public Collection<Entry> getAll() {
        return entries;
    }

    @Override
    public Entry add(Entry item) {
        Entry newItem = new EntryImpl(entries.size() + 1, item.getTopicId(), item.getHeader(), item.getMessage());
        entries.add(newItem);
        return newItem;
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
