package ru.s1x6.travelcosts.budget;

import ru.s1x6.travelcosts.money.Money;

import java.time.temporal.ChronoUnit;

public interface BudgetItem {
    String getName();

    Money getMoney();

    ChronoUnit getPeriodicity();

    boolean isOncePaid();

    boolean isShared();
}
