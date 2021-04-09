package ru.s1x6.travelcosts.period;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class DatePeriod {
    private LocalDate startDate;
    private LocalDate endDate;
    private Period period;

    public DatePeriod(LocalDate startDate, Period period) {
        this.startDate = startDate;
        this.period = period;
        this.endDate = startDate.plus(period);
    }

    public long toDays() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
}
