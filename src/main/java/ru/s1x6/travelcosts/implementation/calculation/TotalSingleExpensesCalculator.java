package ru.s1x6.travelcosts.implementation.calculation;

import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.calculation.Calculator;
import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.model.Travel;
import ru.s1x6.travelcosts.money.Currency;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.request.DescriptionRequest;
import ru.s1x6.travelcosts.request.TotalSingleExpensesRequest;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class TotalSingleExpensesCalculator implements Calculator {

    @Override
    public CalculationResult calculate(Travel travel, Currency targetCurrency) {
        Money money = new Money(0.0, targetCurrency);
        travel.getBudgetItems().forEach(bi -> {
            if (!bi.isExpense()) return;
            if (bi.isOncePaid()) {
                addIfOncePaid(travel, targetCurrency, money, bi);
                return;
            }
            addIfRegular(travel, money, bi);
        });
        return new CalculationResult(null, money, travel.getPeriod(), travel.getParticipants());
    }

    @Override
    public Class<? extends DescriptionRequest> getRequestType() {
        return TotalSingleExpensesRequest.class;
    }

    private void addIfRegular(Travel travel, Money money, BudgetItem bi) {
        Double value = bi.getMoney().getValue();
        long between = ChronoUnit.DAYS.between(travel.getStartDate(), travel.getStartDate().plus(travel.getPeriod()));
        value = value * between / bi.getPeriodicity().getDuration().toDays();
        if (bi.isShared()) {
            value /= travel.getParticipants();
        }
        money.add(new Money(value, bi.getMoney().getCurrency()).convertTo(money.getCurrency()).getValue());
    }

    private void addIfOncePaid(Travel travel, Currency targetCurrency, Money money, BudgetItem bi) {
        Double value = bi.getMoney().convertTo(targetCurrency).getValue();
        if (bi.isShared()) {
            value /= travel.getParticipants();
        }
        money.add(value);
    }
}
