package controller;

import java.util.List;

public class Execution {
    public static void main(String[] args) {
        ImportFileAndRetornClient input = new ImportFileAndRetornClient("/home/felipe/Documents/tw.txt");

        Hotel lakewood = new Hotel(3, "Lakewoood", 110.00, 90.00, 80.00, 80.00);
        Hotel bridgewood = new Hotel(4, "Bridgewood", 160.00, 60.00, 110.00, 50.00);
        Hotel ridgewood = new Hotel(5, "Ridgewood", 220.00, 150.00, 100.00, 40.00);

        List hotels = List.of(lakewood, bridgewood, ridgewood);

        for (ClientReservation cliente : input.getClientReservation()) {
            var calculateHotelPrice = new CalculateHotelPrice(hotels,cliente);
            try {
                calculateHotelPrice.runner();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}