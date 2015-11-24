package com.logistic.impl.model.person;


/**
 * Created by HP_Delphi on 06.11.2015.
 */
public class Address implements com.logistic.api.model.person.Address{
    public Address(String street, String city, String country, int code) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.code = code;
    }

    private String street;
    private String city;
    private String country;
    private int code;

    @Override
    public String toString() {
        return
//                "Address{" +
//                "country ='" + country + '\'' +
//                ", city ='" +
                        city + '\'' // +
//                ",street ='" + street + '\'' +
//                ", code=" + code +
//                '}'
    ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        return code == address.code;

    }

    @Override
    public int hashCode() {
        return code;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}


