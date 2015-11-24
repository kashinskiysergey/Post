package com.logistic.api;

import com.logistic.api.service.Storage;
import com.logistic.impl.model.post.PostOffice;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Storage.getInstance().putToStorage("1", "Bla");
        Storage.getInstance().putToStorage("2", new Integer(45));
        Storage.getInstance().putToStorage("ns", new NestedClasses());

        Integer i = Storage.getInstance().<Integer>getById("2");
        String s = Storage.getInstance().<String>getById("1");
//        Integer ns = Storage.getInstance().<Integer>getById("ns");

        System.out.println(i);
        System.out.println(s);
        //i = Storage.getInstance().<Integer>getById("1");// don't do like this!!!! You should know about the type inside!!!
        System.out.println(Storage.getInstance().<Integer>getById("1"));// But you can do this here java doesn't do a cast to a variable
        System.out.println(Storage.getInstance().<Integer>getById("ns"));

        List<Integer> in = new ArrayList<>();
        in.add(new Integer(2));
        Storage.getInstance().putToStorage("e1", in);
        System.out.println(Storage.getInstance().<List>getById("e1"));

//        new PostOffice().setCode(56).setGeolocation(new Point(90, 67));

    }

    private static class NestedClasses<T extends Number, K extends Integer, M extends Double> {
        public T doSmth(K k) {
            return (T) new Integer(4);
        }

        public T doSmth(M k) {
            return (T) new Integer(4);
        }
    }
}
