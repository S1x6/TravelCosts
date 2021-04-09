package ru.s1x6.travelcosts.implementation.calculation;

import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.calculation.Calculator;
import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.model.Travel;
import ru.s1x6.travelcosts.money.Currency;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.period.DatePeriod;
import ru.s1x6.travelcosts.request.DescriptionRequest;
import ru.s1x6.travelcosts.request.FirstMonthSingleExpensesRequest;

import javax.enterprise.context.ApplicationScoped;
import java.time.Period;

@ApplicationScoped
public class FirstMonthSingleExpensesCalculator implements Calculator {

    @Override
    public CalculationResult calculate(Travel travel, Currency targetCurrency) {
        Money money = new Money(0.0, targetCurrency);
        travel.getBudgetItems().forEach(bi -> {
            if (!bi.isExpense()) return;
            if (bi.isOncePaid()) {
                addIfOncePaid(travel, targetCurrency, money, bi);
                return;
            }
            money.add(bi.getMoney().convertTo(money.getCurrency()).getValue());
        });
        return new CalculationResult(null,
                money,
                new DatePeriod(travel.getDatePeriod().getStartDate(), Period.of(0,1,0)),
                travel.getParticipants());
    }

    private void addIfOncePaid(Travel travel, Currency targetCurrency, Money money, BudgetItem bi) {
        Double value = bi.getMoney().convertTo(targetCurrency).getValue();
        if (bi.isShared()) {
            value /= travel.getParticipants();
        }
        money.add(value);
    }

    @Override
    public Class<? extends DescriptionRequest> getRequestType() {
        return FirstMonthSingleExpensesRequest.class;
    }
}
