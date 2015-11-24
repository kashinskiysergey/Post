package com.logistic.impl.model.person;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;

/**
 * Created by HP_Delphi on 06.11.2015.
 */
public class Person implements com.logistic.api.model.person.Person {

    private Address address;
    private FullName fullName;

    public Person(FullName fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", fullName=" + fullName +
                '}';
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public FullName getFullName() {
        return this.fullName;
    }
}
