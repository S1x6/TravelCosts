package ru.s1x6.travelcosts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.money.Money;

import java.time.Period;

@AllArgsConstructor
@Getter
public class CalculationResult {
    private BudgetItem budgetItem;
    private Money money;
    private Period period;
    private Integer participants;
}
