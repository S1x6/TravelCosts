package ru.s1x6.travelcosts.period;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {
    @Test
    public void test() {
        LocalDate.now().plus(Duration.ofDays(2));
    }
}