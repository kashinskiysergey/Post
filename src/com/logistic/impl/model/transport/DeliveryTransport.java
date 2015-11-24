package com.logistic.impl.model.transport;

import com.logistic.api.model.post.PostOffice;

/**
 * Created by HP_Delphi on 07.11.2015.
 */
public class DeliveryTransport implements com.logistic.api.model.transport.DeliveryTransport {
    private Type type;
    private PostOffice startPostOffice;
    private PostOffice destinationPostOffice;

    public DeliveryTransport(Type type, PostOffice startPostOffice, PostOffice destinationPostOffice) {
        this.type = type;
        this.startPostOffice = startPostOffice;
        this.destinationPostOffice = destinationPostOffice;
    }

    @Override
    public String toString() {
        return "DeliveryTransport{" +
                "type=" + type +
                ", startPostOffice=" + startPostOffice +
                ", destinationPostOffice=" + destinationPostOffice +
                '}';
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public PostOffice getStartPostOffice() {
        return this.startPostOffice;
    }

    @Override
    public PostOffice getDestinationPostOffice() {
        return this.destinationPostOffice;
    }
}
