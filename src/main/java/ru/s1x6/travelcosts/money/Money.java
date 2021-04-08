package ru.s1x6.travelcosts.money;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Money {
    private Double value;
    private Currency currency;

    public void add(Double value) {
        this.value += value;
    }

    public void subtract(Double value) {
        this.value -= value;
    }

    public Money convertTo(Currency currency){
        return new Money(this.value / this.currency.getUsdRate() * currency.getUsdRate(), currency);
    }

    public void divide(Integer num) {
        this.value /= num;
    }
}
