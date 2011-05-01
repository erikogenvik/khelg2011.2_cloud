package com.jayway.khelg.rest.dto;

import java.util.Date;

public class EntryDTO extends LinkedDTOBase {
    public long id;
    public Date date;
    public String header;
    public String message;
}
