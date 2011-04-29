package com.jayway.khelg.model;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jayway.khelg.domain.Entry;

@PersistenceCapable
public class EntryImpl implements Entry {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
    private String key;

    @Extension(vendorName = "datanucleus", key = "gae.pk-id", value = "true")
    private Long id;
    @Persistent
    private Date date;
    @Persistent
    private String header;
    @Persistent
    private String message;

    public EntryImpl(String header, String message) {
        this.date = new Date();
        this.header = header;
        this.message = message;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
