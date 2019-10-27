package controller.model;

import java.time.LocalDate;
import java.util.List;

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

    public double CalculateHotelPrice(List<LocalDate> dates, ClientType clientType) {
        return dates.stream().mapToDouble(it -> this.GetPrice(it, clientType)).sum();
    }

}
