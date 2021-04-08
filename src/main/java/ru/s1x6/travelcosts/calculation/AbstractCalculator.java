package ru.s1x6.travelcosts.calculation;

import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.model.CalculationResult;

import java.util.List;

public abstract class AbstractCalculator {
    public abstract CalculationResult calculate(BudgetItem budgetItem);
    public abstract Class<BudgetItem> getType();
}
