package com.logistic.impl.service;


import com.logistic.api.model.post.*;
import com.logistic.api.model.post.Package;
import com.logistic.api.model.transport.Transit;
import com.logistic.api.service.Storage;
import com.logistic.impl.model.person.Address;
import com.logistic.impl.model.post.PostOffice;
import com.logistic.impl.model.post.Stamp;
import com.logistic.api.model.transport.DeliveryTransport;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class StoregeHelper {


    public static final String TRANSIT_PREFIX = "_transit";
    public static final String POST_OFFICES_KEY = "postOffices";
    public static final String ADDRESSES_KEY = "addresses";
    public static final String DELIVERY_TRANSPORTS_KEY = "deliveryTransports";
    public static final String AVAILABLE_TRANSITS_KEY = "transits";


    public static void initObj() {
        Random random = new Random();

        Storage.getInstance().putToStorage(ADDRESSES_KEY, Arrays.asList(
                new Address("Lenina st.40", "Kharkov", "Ukraine", 057),
                new Address("Pl.Rinok st.2", "Lviv", "Ukraine", 032),
                new Address("Gagarina st.125", "Uzgorod", "Ukraine", 031),
                new Address("Bogatirska st.22", "Kiev", "Ukraine", 044),
                new Address("Ushakova st.57", "Herson", "Ukraine", 055)
        ));

        Storage.getInstance().putToStorage(POST_OFFICES_KEY, Arrays.asList(
                new com.logistic.impl.model.post.PostOffice(new Address("Lenina st.40", "Kharkov", "Ukraine", 057), Package.Type.T_30, 35, new Point(0, 0)),
                new com.logistic.impl.model.post.PostOffice(new Address("Pl.Rinok st.2", "Lviv", "Ukraine", 032), Package.Type.T_30, 30, new Point(2, 3)),
                new com.logistic.impl.model.post.PostOffice(new Address("Gagarina st.12", "Uzgorod", "Ukraine", 031), Package.Type.T_30, 30, new Point(2, 3)),
                new com.logistic.impl.model.post.PostOffice(new Address("Bogatirska st.22", "Kiev", "Ukraine", 044), Package.Type.T_30, 40, new Point(2, 3)),
                new com.logistic.impl.model.post.PostOffice(new Address("Ushakova st.57", "Herson", "Ukraine", 055), Package.Type.T_30, 20, new Point(5, 6))
        ));

        Storage.getInstance().putToStorage(DELIVERY_TRANSPORTS_KEY,Arrays.asList(
                //ױאנüךמג-Êטוג
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.LAND, getByPostCode(057), getByPostCode(044)),
                //ױאנüךמג-ױונסמם
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.SEA, getByPostCode(057), getByPostCode(055)),
                //Êטוג-ױונסמם
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.SEA, getByPostCode(044), getByPostCode(055)),
                //Êטוג-ֻüגמג
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.LAND, getByPostCode(044), getByPostCode(032)),
                //ױונסמם-ֻüגמג
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.SEA, getByPostCode(055), getByPostCode(032)),
                //׃זדמנמה-ֻüגמג
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.AIR, getByPostCode(031), getByPostCode(032)),
                //׃זדמנמה-ױונסמם
                new com.logistic.impl.model.transport.DeliveryTransport(DeliveryTransport.Type.AIR, getByPostCode(031), getByPostCode(055))
                ));


        Storage.getInstance().putToStorage(AVAILABLE_TRANSITS_KEY,Arrays.asList(
                //Kharkov - Herson
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(055)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(044), getByPostCode(055)), random.nextInt(100)+20),
                //Kharkov - Kiev
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(044)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(055), getByPostCode(044)), random.nextInt(100)+20),
                //Kharkov - Lvov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(044), getByPostCode(032)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(055), getByPostCode(032)), random.nextInt(100)+20),
                //Kharkov - Uzgorod
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(044), getByPostCode(032), getByPostCode(031)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(055), getByPostCode(032), getByPostCode(031)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(057), getByPostCode(055), getByPostCode(031)), random.nextInt(100)+20),

                //Herson - Kharkov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(057)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(044), getByPostCode(057)), random.nextInt(100)+20),
                //Herson - Kiev
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(044)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(057), getByPostCode(044)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(032), getByPostCode(044)), random.nextInt(100)+20),
                //Herson - Lvov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(032)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(031), getByPostCode(032)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(044), getByPostCode(032)), random.nextInt(100)+20),
                //Herson - Uzgorod
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(031)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(055), getByPostCode(032), getByPostCode(031)), random.nextInt(100)+20),

                //Kiev - Kharkov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(057)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(055), getByPostCode(057)), random.nextInt(100)+20),
                //Kiev - Lvov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(032)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(055), getByPostCode(032)), random.nextInt(100)+20),
                //Kiev - Herson
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(055)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(055)), random.nextInt(100)+20),
                //Kiev - Uzgorod
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(055), getByPostCode(031)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(044), getByPostCode(032), getByPostCode(031)), random.nextInt(100)+20),

                //Lvov - Uzgorod
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(031)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(055), getByPostCode(031)), random.nextInt(100)+20),
                //Lvov - Kiev
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(055), getByPostCode(044)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(044)), random.nextInt(100)+20),
                //Lvov - Herson
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(055)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(031), getByPostCode(055)), random.nextInt(100)+20),
                //Lvov - Kharkov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(055), getByPostCode(057)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(032), getByPostCode(044), getByPostCode(057)), random.nextInt(100)+20),

                //Uzgorod - Lvov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(032)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(055), getByPostCode(032)), random.nextInt(100)+20),
                //Uzgorod - Herson
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(055)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(032), getByPostCode(055)), random.nextInt(100)+20),
                //Uzgorod - Kiev
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(032), getByPostCode(044)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(055), getByPostCode(044)), random.nextInt(100)+20),
                //Uzgorod - Kharkov
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(032), getByPostCode(044), getByPostCode(057)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(032), getByPostCode(055), getByPostCode(057)), random.nextInt(100)+20),
                new com.logistic.impl.model.transport.Transit(Arrays.asList(getByPostCode(031), getByPostCode(055), getByPostCode(057)), random.nextInt(100)+20)
        ));


        }


        public static List<PostOffice> getAllOffices () {
            return Storage.getInstance().<List>getById(POST_OFFICES_KEY);
        }

        public static List<DeliveryTransport> getDeliveryTransports () {
            return Storage.getInstance().<List>getById(DELIVERY_TRANSPORTS_KEY);
        }

        public static List<Transit> getTransits () {
            return Storage.getInstance().<List>getById(AVAILABLE_TRANSITS_KEY);
        }




    public static void saveParcelTransit(Package parcel, Transit transit) {
        Storage.getInstance().putToStorage(parcel.getPackageId(), parcel);
        Storage.getInstance().putToStorage(parcel.getPackageId() + TRANSIT_PREFIX, transit);

    }

    public static PostOffice getByPostCode(int code) {
        List<PostOffice> offices = Storage.getInstance().<List>getById(POST_OFFICES_KEY);
        for (PostOffice postOffice : offices) {
            if (postOffice.getAddress().getCode() == code) {
                return postOffice;
            }
        }
        return null;
    }

    public static Package getPackage(String id) {
        return Storage.getInstance().<Package>getById(id);
    }

    public static Transit getTransit(String id) {
        return Storage.getInstance().<Transit>getById(id + TRANSIT_PREFIX);
    }

    public static com.logistic.api.model.person.Address getRandomAddress() {
        Random random = new Random();
        List<Address> addresses = Storage.getInstance().<List>getById(ADDRESSES_KEY);
        return addresses.get(random.nextInt(addresses.size()));
    }
}



