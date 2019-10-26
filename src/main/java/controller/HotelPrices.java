package controller;

public class HotelPrices {
    private Hotel hotel;
    private Double price;

    public HotelPrices(Hotel hotel, Double price) {
        this.hotel = hotel;
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Double getPrice() {
        return price;
    }
}
