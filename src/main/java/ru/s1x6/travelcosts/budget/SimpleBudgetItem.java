package ru.s1x6.travelcosts.budget;

import lombok.AllArgsConstructor;
import ru.s1x6.travelcosts.money.Money;

import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class SimpleBudgetItem implements BudgetItem {

    private final String name;
    private final Money money;
    private final ChronoUnit periodicity;
    private final boolean isOncePaid;
    private final boolean isShared;
    private final boolean isExpense;

    @Override
    public boolean isExpense() {
        return isExpense;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public ChronoUnit getPeriodicity() {
        return periodicity;
    }

    @Override
    public boolean isOncePaid() {
        return isOncePaid;
    }

    @Override
    public boolean isShared() {
        return isShared;
    }
}
