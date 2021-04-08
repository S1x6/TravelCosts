package ru.s1x6.travelcosts.model;

import lombok.Getter;
import ru.s1x6.travelcosts.budget.BudgetItem;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Travel {
    private List<BudgetItem> expenses = new ArrayList<>();
    private List<BudgetItem> incomes = new ArrayList<>();
    private Period period;
    private Integer participants;

    public Travel(Period period, Integer participants) {
        this.period = period;
        this.participants = participants;
    }

    public void registerAsIncome(BudgetItem budgetItem) {
        incomes.add(budgetItem);
    }

    public void registerAsExpense(BudgetItem budgetItem) {
        expenses.add(budgetItem);
    }
}
