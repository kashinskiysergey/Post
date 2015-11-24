package com.logistic.impl.model.transport;

import com.logistic.api.model.post.PostOffice;
import com.logistic.impl.model.post.Stamp;

import java.util.List;


public class Transit implements com.logistic.api.model.transport.Transit {
    private List<PostOffice> transitOffice;
    private double price;

    public Transit(List<PostOffice> transitOffice, double price) {
        this.transitOffice = transitOffice;
        this.price = price;
    }

    @Override
    public String toString() {
        return //"Transit{" +
                "transitOffice=" + transitOffice +
                        ", price=" + price //+
//                '}'
                ;
    }

    @Override
    public List<PostOffice> getTransitOffices() {
        return this.transitOffice;
    }

    @Override
    public double getPrice() {
        return price;
    }

}