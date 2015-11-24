package com.logistic.impl.model.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.Stamp;


import java.awt.*;
import java.util.Date;

/**
 * Created by HP_Delphi on 06.11.2015.
 */
public class PostOffice implements com.logistic.api.model.post.PostOffice {
    private Address address;
    public Package.Type acceptableType;
    private int maxWeight;
    public Point geolocation;

    public PostOffice(Address address, Package.Type acceptableType, int maxWeight, Point geolocation) {
        this.address = address;
        this.acceptableType = acceptableType;
        this.maxWeight = maxWeight;
        this.geolocation = geolocation;
    }

    @Override
    public String toString() {
        return
//                "PostOffice{" +
                "address=" + address +
//                ", acceptableType=" + acceptableType +
                ", maxWeight=" + maxWeight                     //+
//                ", geolocation=" + geolocation +
//                '}'
                ;
    }

    @Override
    public Stamp getStamp() {
        return new com.logistic.impl.model.post.Stamp(this.address, new Date());


    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public Package.Type getAcceptableTypes() {
        return this.acceptableType;
    }

    @Override
    public  int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public boolean sendPackage(Package parcel) {
        return !parcel.getReceiverPerson().equals(address);
    }

    @Override
    public boolean receivePackage(Package parcel) {

        parcel.getStamps().add(getStamp());
        return true;
    }

    @Override
    public int getCode() {
        return this.address.getCode();
    }

    @Override
    public Point getGeolocation() {
        return this.geolocation;
    }


}
