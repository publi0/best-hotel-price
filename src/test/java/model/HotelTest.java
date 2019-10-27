package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void calculateHotelPrice() {
        Hotel bridgewood = new Hotel(4, "Bridgewood", 160.00, 60.00, 110.00, 50.00);

        var dateWeekAndWeekendDays = List.of(LocalDate.of(2019, 10, 27), LocalDate.of(2019, 10, 28),
                LocalDate.of(2019, 10
                , 29), LocalDate.of(2019, 10, 30));
        var dateWeekDays = List.of(LocalDate.of(2019, 10, 28), LocalDate.of(2019, 10
                , 29), LocalDate.of(2019, 10, 30));

        var dateWeekendDays = List.of(LocalDate.of(2019, 10, 26), LocalDate.of(2019, 10
                , 27));

        assertEquals(bridgewood.CalculateHotelPrice(new Client(ClientType.REGULAR, dateWeekAndWeekendDays)), 540.0,
                "Regular client, One weekend day and three week days in Bridgewood hotel");
        assertEquals(bridgewood.CalculateHotelPrice(new Client(ClientType.REWARDS, dateWeekAndWeekendDays)), 380.0,
                "Rewards client, One weekend day and three week days in Bridgewood hotel");

        assertEquals(bridgewood.CalculateHotelPrice(new Client(ClientType.REGULAR, dateWeekDays)), 480.0, "Regular " +
                "client, " +
                "three week days in Bridgewood hotel");
        assertEquals(bridgewood.CalculateHotelPrice(new Client(ClientType.REWARDS, dateWeekDays)), 330.0, "Rewards " +
                "client, One three week days in Bridgewood hotel");

        assertEquals(bridgewood.CalculateHotelPrice(new Client(ClientType.REGULAR, dateWeekendDays)), 120.0, "Regular " +
                "client, two weekend days in Bridgewood hotel");
        assertEquals(bridgewood.CalculateHotelPrice(new Client(ClientType.REWARDS, dateWeekendDays)), 100.0, "Rewards " +
                "client, two weekend days in Bridgewood hotel");

    }
}