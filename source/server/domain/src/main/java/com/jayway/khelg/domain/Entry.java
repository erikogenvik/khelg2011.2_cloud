package com.jayway.khelg.domain;

import java.util.Date;

public interface Entry extends Identifiable{

    Date getDate();

    String getHeader();

    String getMessage();

    long getTopicId();

}
