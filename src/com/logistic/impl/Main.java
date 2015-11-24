package com.logistic.impl;


import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.impl.model.person.FullName;
import com.logistic.impl.model.person.Person;
import com.logistic.api.service.Storage;
import com.logistic.impl.model.person.Address;
import com.logistic.impl.model.post.*;
import com.logistic.impl.model.post.PostOffice;
import com.logistic.impl.model.post.Stamp;
import com.logistic.impl.model.transport.DeliveryTransport;
import com.logistic.impl.model.transport.Transit;
import com.logistic.impl.service.SenderService;
import com.logistic.impl.service.StoregeHelper;
import javafx.scene.chart.PieChart;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StoregeHelper.initObj();

        Thread threadSender = new Thread(new SenderService());                              //Вывод потока
        threadSender.start();


        Address antonA = new Address("Lenina st.40", "Kharkov", "Ukraine", 057);          //Отправитель
        FullName antonF = new FullName("Antotn","Kolesnik","Vladimirovich");              //Отправитель
        Person Anton = new Person(antonF, antonA);                                        //Отправитель

        Address VikaA = new Address("Pl.Rinok st.2", "Lviv", "Ukraine", 032);             //Получатель
        FullName VikaF = new FullName("Viktoria","Kolesnik","Vladimirovna");              //Получатель
        Person Vika = new Person(VikaF, VikaA);                                           //Получатель

        Address wladA = new Address("Gagarina st.125", "Uzgorod", "Ukraine", 031);        //Получатель
        FullName wladF = new FullName("Wladislaw","Babiyshuk","Olegovich");               //Получатель
        Person Wlad = new Person(wladF,wladA);                                            //Получатель

        Address pavelA = new Address("Bogatirska st.22", "Kiev", "Ukraine", 044);         //Получатель
        FullName pavelF = new FullName("Dovjenko","Pavel","Georgievich");                 //Получатель
        Person Pavel = new Person(pavelF,pavelA);                                         //Получатель

        Address alexA = new Address("Ushakova st.57", "Herson", "Ukraine", 055);          //Получатель
        FullName alexF = new FullName("Zubko","Alexey","Pavlovich");                      //Получатель
        Person Alex = new Person(alexF,alexA);                                            //Получатель

        Packagee newBox = new Packagee(Anton, Wlad, Package.Type.T_10, 30);
        Packagee newBigBox = new Packagee(Vika, Alex, Package.Type.T_27, 20);
        Packagee Box = new Packagee(Pavel, Wlad, Package.Type.T_27, 20);

        SenderService service = new SenderService();

        System.out.println(service.calculatePossibleTransits(newBox));
        System.out.println(service.sendPackage(newBox, service.calculatePossibleTransits(newBox).get(0)));
        System.out.println(newBox.getPackageId());
        System.out.println(newBox.getStamps());
        System.out.println("\n");

        System.out.println(service.calculatePossibleTransits(newBigBox));
        System.out.println(service.sendPackage(newBigBox, service.calculatePossibleTransits(newBigBox).get(1)));
        System.out.println(newBigBox.getPackageId());
        System.out.println(newBigBox.getStamps());
        System.out.println("\n");

        System.out.println(service.calculatePossibleTransits(Box));
        System.out.println(service.sendPackage(Box, service.calculatePossibleTransits(Box).get(0)));
        System.out.println(Box.getPackageId());
        System.out.println(Box.getStamps());
        System.out.println("\n");



    }


}






















