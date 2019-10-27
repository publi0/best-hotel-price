package controller.business;

import controller.model.Client;
import controller.model.Hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.*;

public class CalculateHotelPrice {
    private List<Hotel> availablehotels;
    private Client client;

    public CalculateHotelPrice(List<Hotel> availablehotels, Client client) {
        this.availablehotels = availablehotels;
        this.client = client;
    }

    public String GetBestHotel() {
        availablehotels.sort((h1, h2) -> {
            if (h1.CalculateHotelPrice(client.getDates(), client.getClientType()) == h2.CalculateHotelPrice(client.getDates(), client.getClientType())) {
                if (h1.getClassification() > h2.getClassification()) {
                    return -1;
                } else
                    return 1;
            } else if (h1.CalculateHotelPrice(client.getDates(), client.getClientType()) > h2.CalculateHotelPrice(client.getDates(), client.getClientType())) {
                return 1;
            } else
                return -1;
        });
        return availablehotels.get(0).getName();
    }
}
