package com.logistic.api.model.transport;

import com.logistic.api.model.post.PostOffice;
import java.util.List;


public interface Transit {
    public List<PostOffice> getTransitOffices();
    public double getPrice();
}
