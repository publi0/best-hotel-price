package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculateHotelPrice {
    private List<Hotel> hotel;
    private ClientReservation clientReservation;
    private Integer clientWeekDays = 0;
    private Integer clientWeekEndDays = 0;
    private List<HotelPrices> hotelPrices = new ArrayList<>();

    public CalculateHotelPrice(List<Hotel> hotel, ClientReservation clientReservation) {
        this.hotel = hotel;
        this.clientReservation = clientReservation;
    }

    public void runner() throws Exception {
        findDayType();
        calculateHotelPrices();
        hotelPrices.forEach(it -> System.out.println(it.getHotel().getName() + " " +it.getPrice()));
    }

    private void findDayType() throws Exception {
        for (String data : clientReservation.getDates()) {
            String daytype = data.substring(data.indexOf("(") + 1, data.indexOf(")"));
            switch (daytype.trim()) {
                case "mon":
                case "tues":
                case "wed":
                case "thur":
                case "fri":
                    clientWeekDays += 1;
                    break;
                case "sat":
                case "sun":
                    clientWeekEndDays += 1;
                    break;
                default:
                    throw new Exception("Invalid day type: " + daytype);
            }
        }
    }

    private void calculateHotelPrices() throws Exception {
        if (clientWeekEndDays != 0 || clientWeekDays != 0) {
            for (Hotel hotel : hotel) {
                Double price = 0.0;
                if (clientReservation.getClientType().equals("regular")) {
                    price = getHotelPriceForRegular(hotel);
                } else if (clientReservation.getClientType().equals("rewards")) {
                    price = getHotelPriceForRewards(hotel);
                } else {
                    throw new Exception("Invalid client type: " + clientReservation.getClientType());
                }
                hotelPrices.add(new HotelPrices(hotel, price));
            }
        } else {
            throw new Exception("Could not find any day");
        }
    }

    private Double getHotelPriceForRewards(Hotel hotel) {
        return (hotel.getFidelityWeekPrice() * clientWeekDays) + (hotel.getFidelityWeekEndPrice() * clientWeekEndDays);
    }

    private Double getHotelPriceForRegular(Hotel hotel) {
        return (hotel.getWeekPrice() * clientWeekDays) + (hotel.getWeekEndPrice() * clientWeekEndDays);
    }
}
