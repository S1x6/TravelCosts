package ru.s1x6.travelcosts.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.s1x6.travelcosts.money.Currency;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.period.DatePeriod;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class CalculationResultTest {

    @Test
    void convertTo() {
        CalculationResult result = new CalculationResult(null,
                new Money(91.0, Currency.RUB),
                new DatePeriod(LocalDate.of(2021, 4, 9), Period.of(0, 3, 0)),
                1
        );
        Assertions.assertEquals(1.0, result.convertTo(ChronoUnit.DAYS).getValue());
        Assertions.assertEquals(30.0, result.convertTo(ChronoUnit.MONTHS).getValue());
    }
}