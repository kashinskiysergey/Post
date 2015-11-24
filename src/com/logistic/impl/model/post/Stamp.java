package com.logistic.impl.model.post;

import com.logistic.api.model.person.Address;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HP_Delphi on 06.11.2015.
 */
public class Stamp implements com.logistic.api.model.post.Stamp{

    private Address postOfficeAddress;
    private Date stampDate;


    public Stamp(Address postOfficeAddress, Date stampDate) {
        this.postOfficeAddress = postOfficeAddress;
        this.stampDate = stampDate;
    }

    @Override
    public String toString() {
        return  "stamp = " + stampDate;
    }

    @Override
    public Address getPostOfficeAddress() {
        return this.postOfficeAddress;
    }

    @Override
    public Date getStampDate() {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("День dd Месяц MM Год yyyy Время hh:mm");
        System.out.println(format1.format(d));
        System.out.println(format2.format(d));
        return this.stampDate;
    }                                           //Создает Штамп "Дата, Время"
}
