package com.logistic.impl.service;


import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.post.PostOffice;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.service.Storage;
import com.logistic.impl.model.person.Address;
import com.logistic.impl.model.post.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SenderService implements com.logistic.api.service.SenderService, Runnable{




    @Override
    public void run() {
        System.out.println("Поток run в классе SenderService  =>>  "  + Storage.getInstance().<Address>getById(StoregeHelper.POST_OFFICES_KEY));     //Поток вывода всех PostOffice
        System.out.println("\n");
    return;
    }                       //Пробная версия многопоточности

    @Override
    public List<PostOffice> getAllOffices() {
        return null;
    }

    @Override
    public List<Transit> calculatePossibleTransits(com.logistic.api.model.post.Package parcel) {
        List<Transit> targets = new ArrayList<>();
        for(Transit t :  Storage.getInstance().<List<Transit>>getById("transits")){                   //Проходим Транзитом "t" по всем Транзитам

            PostOffice sendOffice = t.getTransitOffices().get(0);                                       //Присваиваем отправной пункт
            PostOffice receiverOffice = t.getTransitOffices().get(t.getTransitOffices().size() - 1);    //Присваиваем конечный пункт
            boolean b = true;
            for (PostOffice p : t.getTransitOffices()){                                                 //Проходим ПостОффисом "р" по всем Оффисам Транзитов
                if (parcel.getWeight() > p.getMaxWeight()){                                             //Если посылка весит больше допустимого
                    b = false;
                }


            }
            if(sendOffice.getAddress().equals(parcel.getSenderPerson().getAddress()) &&                     //Если совпал начальный пункт и первый
            receiverOffice.getAddress().equals(parcel.getReceiverPerson().getAddress()) && b == true){      //пункт существующего транзита и конечный
                targets.add(t);                                                                             //пункт и вес не привышает нормы


            }
        }
        System.out.println("Kоличество возможных маршрутов : " + targets.size());


        return targets;




    }         //работающий метод выбота пути доставки

    @Override
    public boolean sendPackage(Package parcel, Transit transit) {
        for(PostOffice po : transit.getTransitOffices()) {
            po.receivePackage(parcel);
        }

        return true;
    }

    @Override
    public PostOffice getPackageCurrentPosition(String id) {
        return null;
    }

    @Override
    public double getMilesToDestination(String id) {
        return 0;
    }
}
