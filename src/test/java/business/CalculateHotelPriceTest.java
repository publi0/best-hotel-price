package business;

import model.Client;
import model.ClientType;
import model.Hotel;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateHotelPriceTest {

    @Test
    void getBestHotel() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(3, "Lakewood", 110.00, 90.00, 80.00, 80.00));
        hotels.add(new Hotel(4, "Bridgewood", 160.00, 60.00, 110.00, 50.00));
        hotels.add(new Hotel(5, "Ridgewood", 220.00, 150.00, 100.00, 40.00));

        List<LocalDate> localDates01 = List.of(LocalDate.of(2009,3,16), LocalDate.of(2009,3,17), LocalDate.of(2009,3,18));
        List<LocalDate> localDates02 = List.of(LocalDate.of(2009,3,20), LocalDate.of(2009,3,21), LocalDate.of(2009,3,22));
        List<LocalDate> localDates03 = List.of(LocalDate.of(2009,3,26), LocalDate.of(2009,3,27), LocalDate.of(2009,3,28));
        List<LocalDate> localDates04 = List.of(LocalDate.of(2009,3,26), LocalDate.of(2011,3,27), LocalDate.of(20012,3,28));

        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REGULAR, localDates01)).getBestHotel(), "Lakewood", "Lakewood is the best price");
        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REWARDS, localDates01)).getBestHotel(), "Lakewood", "Lakewood is the best price");

        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REGULAR, localDates02)).getBestHotel(), "Bridgewood", "Bridgewood is the best price");
        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REWARDS, localDates02)).getBestHotel(), "Ridgewood", "Bridgewood is the best price");

        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REWARDS, localDates03)).getBestHotel(), "Ridgewood", "Ridgewood is the best price");
        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REGULAR, localDates03)).getBestHotel(), "Lakewood", "Lakewood is the best price");

        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REGULAR, localDates04)).getBestHotel(), "Lakewood", "Ridgewood is the best price");
        assertEquals(new CalculateHotelPrice(hotels, new Client(ClientType.REWARDS, localDates04)).getBestHotel(), "Ridgewood", "Ridgewood is the best price");



    }
}