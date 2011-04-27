package com.jayway.khelg.model;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;

import com.jayway.khelg.domain.Entry;

@PersistenceCapable
public class EntryImpl implements Entry {

    private Date date;
    private String header;
    private String message;

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
