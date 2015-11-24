package com.logistic.api.model.post;

import com.logistic.api.model.person.Address;
import com.logistic.api.model.person.FullName;
import com.logistic.impl.model.person.Person;

import java.util.List;
import java.util.Random;

public interface Package {
//    public Address getReceiverAddress();
//    public FullName getReceiverFullName();
//    public FullName getSenderFullName();
//    public Address getSenderAddress();

    public Person getReceiverPerson();
    public Person getSenderPerson();
    public List<Stamp> getStamps();
    public String getPackageId();
    public int getWeight();


    public Type getType();

    public static enum Type {
        T_CP("Место груза"), T_30("Палета", 50), T_10("Коробка UPS 10 кг", 10),
        T_25("Коробка UPS 25 кг", 25), T_27("Средняя коробка UPS Express");

        private final String description;
        private final int maxWeight;

        private Type(String description) {
            this(description, 0);
        }

        private Type(String description, int maxWeight) {
            this.description = description;
            this.maxWeight = maxWeight;
        }

        public String getDescription() {
            return description;
        }

        public int getMaxWeight() {
            return maxWeight;
        }

        public static Type getRandomType() {
            Random r = new Random();
            return values()[r.nextInt(values().length)];
        }
    }
}
