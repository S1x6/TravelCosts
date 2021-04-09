package ru.s1x6.travelcosts.model;

import lombok.Getter;
import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.period.DatePeriod;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Travel {
    private final List<BudgetItem> budgetItems = new ArrayList<>();
    private final DatePeriod datePeriod;
    private final Integer participants;

    public Travel(DatePeriod datePeriod, Integer participants) {
        this.datePeriod = datePeriod;
        this.participants = participants;
    }

    public void addBudgetItem(BudgetItem budgetItem) {
        budgetItems.add(budgetItem);
    }
}
