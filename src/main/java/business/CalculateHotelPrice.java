package business;

import model.Client;
import model.Hotel;

import java.util.List;

public class CalculateHotelPrice {
    private List<Hotel> availablehotels;
    private Client client;

    public CalculateHotelPrice(List<Hotel> availablehotels, Client client) {
        this.availablehotels = availablehotels;
        this.client = client;
    }

    public String getBestHotel() {
        availablehotels.sort((hotelOne, hotelTwo) -> {
            if (hotelOne.CalculateHotelPrice(client) == hotelTwo.CalculateHotelPrice(client)) {
                if (hotelOne.getClassification() > hotelTwo.getClassification()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (hotelOne.CalculateHotelPrice(client) > hotelTwo.CalculateHotelPrice(client)) {
                return 1;
            } else {
                return -1;
            }
        });
        return availablehotels.get(0).getName();
    }
}