package ru.s1x6.travelcosts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.period.DatePeriod;

import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Getter
public class CalculationResult {
    private final BudgetItem budgetItem;
    private final Money money;
    private final DatePeriod datePeriod;
    private final Integer participants;

    public Money convertTo(ChronoUnit chronoUnit) {
        return new Money(
                money.getValue() / datePeriod.toDays() * chronoUnit.getDuration().toDays(),
                money.getCurrency()
        );
    }

    // должен содержать итоговую сумму (как сейчас), а так же набор одиночных результатов по каждой статье
    // типа на сколько умножали, каждая статья сколько занимает на таком периоде и учитывается ли вообще
    // а реквест может содержать дополнительные параметры типа нужно ли подробно выводить в форматтере или можно
    // даже в калькулятор подавать, записывать ли отдельные статьи или считать только суммарно
}
