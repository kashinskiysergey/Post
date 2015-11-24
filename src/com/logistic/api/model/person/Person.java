package com.logistic.api.model.person;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;

public interface Person {


    public Address getAddress();
    public FullName getFullName();


}
