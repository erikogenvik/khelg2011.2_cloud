package com.jayway.khelg.storage;

import java.util.Collection;

import com.jayway.khelg.domain.Entry;

public interface EntryRepository {
    Collection<Entry> getAll();

    void add(Entry item);

    Entry get(long id);

    Collection<? extends Entry> getAllForTopic(Long id);

    void addForTopic(Long id, Entry entry);
}
