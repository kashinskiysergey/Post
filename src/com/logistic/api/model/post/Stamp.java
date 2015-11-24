 package com.logistic.api.model.post;


import com.logistic.api.model.person.Address;

import java.util.Date;

public interface Stamp {
    public Address getPostOfficeAddress();
    public Date getStampDate();
}