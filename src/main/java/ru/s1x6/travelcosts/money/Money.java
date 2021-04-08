package ru.s1x6.travelcosts.money;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Money {
    private Double value;
    private Currency currency;
}
