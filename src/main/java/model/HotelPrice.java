package model;

import util.DateUtil;

import java.time.LocalDate;

class HotelPrice {
    private Double weekPrice;
    private Double weekEndPrice;
    private Double fidelityWeekPrice;
    private Double fidelityWeekEndPrice;

    protected HotelPrice(Double weekPrice, Double weekEndPrice, Double fidelityWeekPrice, Double fidelityWeekEndPrice) {
        this.weekPrice = weekPrice;
        this.weekEndPrice = weekEndPrice;
        this.fidelityWeekPrice = fidelityWeekPrice;
        this.fidelityWeekEndPrice = fidelityWeekEndPrice;
    }

    protected double getPrice(LocalDate date, ClientType clientType) {
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
