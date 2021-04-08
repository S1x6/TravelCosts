package ru.s1x6.travelcosts.model;

import lombok.Getter;
import ru.s1x6.travelcosts.budget.BudgetItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Travel {
    private final List<BudgetItem> budgetItems = new ArrayList<>();
    private final LocalDate startDate;
    private final Period period;
    private final Integer participants;

    public Travel(LocalDate startDate, Period period, Integer participants) {
        this.startDate = startDate;
        this.period = period;
        this.participants = participants;
    }

    public void addBudgetItem(BudgetItem budgetItem) {
        budgetItems.add(budgetItem);
    }
}
