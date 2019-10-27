package controller.model;

import controller.model.Hotel;
import controller.util.DateUtil;

import java.time.LocalDate;

public class HotelPrice {
    private Double weekPrice;
    private Double weekEndPrice;
    private Double fidelityWeekPrice;
    private Double fidelityWeekEndPrice;

    public HotelPrice(Double weekPrice, Double weekEndPrice, Double fidelityWeekPrice, Double fidelityWeekEndPrice) {
        this.weekPrice = weekPrice;
        this.weekEndPrice = weekEndPrice;
        this.fidelityWeekPrice = fidelityWeekPrice;
        this.fidelityWeekEndPrice = fidelityWeekEndPrice;
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

    public double GetPrice(LocalDate date, ClientType clientType) {
        if (DateUtil.IsWeekend(date)) {
            if (clientType == ClientType.REWARDS) {
                return fidelityWeekEndPrice;
            } else {
                return weekEndPrice;
            }
        } else {
            if (clientType == ClientType.REWARDS) {
                return fidelityWeekPrice;
            } else {
                return weekPrice;
            }
        }
    }

}
