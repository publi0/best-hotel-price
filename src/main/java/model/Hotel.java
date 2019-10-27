package model;

public class Hotel extends HotelPrice {
    private Integer classification;
    private String name;

    public Hotel(Integer classification, String name, Double weekPrice, Double weekEndPrice, Double fidelityWeekPrice
            , Double fidelityWeekEndPrice) {
        super(weekPrice, weekEndPrice, fidelityWeekPrice, fidelityWeekEndPrice);
        this.classification = classification;
        this.name = name;
    }

    public Integer getClassification() {
        return classification;
    }

    public String getName() {
        return name;
    }

    public double CalculateHotelPrice(Client client) {
        return client.getDates().stream().mapToDouble(it -> this.getPrice(it, client.getClientType())).sum();
    }

}
