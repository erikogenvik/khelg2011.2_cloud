package com.jayway.khelg.domain;

import java.util.Date;

public interface Entry extends Identifiable{

    public Date getDate();

    public String getHeader();

    public String getMessage();

}
