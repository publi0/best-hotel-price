package controller;

public class Hotel {
    private Integer classification;
    private String name;
    private Double weekPrice;
    private Double weekEndPrice;
    private Double fidelityWeekPrice;
    private Double fidelityWeekEndPrice;

    public Hotel(Integer classification, String name, Double weekPrice, Double weekEndPrice,
                 Double fidelityWeekPrice, Double fidelityWeekEndPrice) {
        this.classification = classification;
        this.name = name;
        this.weekPrice = weekPrice;
        this.weekEndPrice = weekEndPrice;
        this.fidelityWeekPrice = fidelityWeekPrice;
        this.fidelityWeekEndPrice = fidelityWeekEndPrice;
    }

    public Integer getClassification() {
        return classification;
    }

    public String getName() {
        return name;
    }

    public Double getWeekPrice() {
        return weekPrice;
    }

    public Double getWeekEndPrice() {
        return weekEndPrice;
    }

    public Double getFidelityWeekPrice() {
        return fidelityWeekPrice;
    }

    public Double getFidelityWeekEndPrice() {
        return fidelityWeekEndPrice;
    }
}
