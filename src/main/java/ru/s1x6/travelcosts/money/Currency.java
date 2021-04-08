package ru.s1x6.travelcosts.money;

public enum Currency {
    RUB(76.16), USD(1.0), WON(1127.8);
    private Double usdRate;

    Currency(Double usdRate) {
        this.usdRate = usdRate;

    }

    public Double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(Double usdRate) {
        this.usdRate = usdRate;
    }
}

