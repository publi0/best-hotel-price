package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HotelPriceTest {

    @Test
    void getPrice() {
        HotelPrice hotelPrice = new HotelPrice(110.00, 90.00, 80.00, 80.00);
        assertEquals(hotelPrice.getPrice(LocalDate.of(2019,10,27),ClientType.REGULAR), 90.0,"Regular client in weekend day");
        assertEquals(hotelPrice.getPrice(LocalDate.of(2019,10,31),ClientType.REGULAR), 110.0, "Regular client in week day");
        assertEquals(hotelPrice.getPrice(LocalDate.of(2019,10,27),ClientType.REWARDS), 80.0,"Rewards client in weekend day");
        assertEquals(hotelPrice.getPrice(LocalDate.of(2019,10,31),ClientType.REWARDS), 80.0, "Rewards client in week day");
    }
}