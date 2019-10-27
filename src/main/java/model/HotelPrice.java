package model;

import util.DateUtil;

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

    public double getPrice(LocalDate date, ClientType clientType) {
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
