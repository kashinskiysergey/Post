package com.logistic.impl.model.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Stamp;
import com.logistic.impl.model.person.Person;
import com.logistic.impl.service.SenderService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Packagee implements com.logistic.api.model.post.Package {
    private String packageId;
    private int weight;
    private Type type;
    private List<Stamp> stamps;
    private Person senderPerson;
    private Person receiverPerson;


//    private Address recevierAddress;
//    private Address senderAddress;
//    private FullName recevierFullName;
//    private FullName senderFullName;


    public Packagee(Person senderPerson ,Person receiverPerson , Type type, int weight) {
        this.packageId = UUID.randomUUID().toString();
        this.type = type;
        this.weight = weight;
        this.receiverPerson = receiverPerson;
        this.senderPerson = senderPerson;
        this.stamps = new ArrayList<>();


//        this.senderFullName = senderFullName;
//        this.recevierFullName = recevierFullName;
//        this.senderAddress = senderAddress;
//        this.recevierAddress = recevierAddress;
    }




    @Override
    public String getPackageId() {
        return this.packageId;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public Person getReceiverPerson() {
        return this.receiverPerson;
    }

    @Override
    public Person getSenderPerson() {
        return this.senderPerson;
    }

    @Override
    public List<Stamp> getStamps() {

         return this.stamps;
    }



//    @Override
//    public Address getReceiverAddress() {
//        return this.recevierAddress;
//    }
//
//    @Override
//    public Address getSenderAddress() {
//        return this.senderAddress;
//    }
//
//    @Override
//    public FullName getSenderFullName() {
//        return this.senderFullName;
//    }
//
//    @Override
//    public FullName getReceiverFullName() {
//        return this.recevierFullName;
//    }


}
