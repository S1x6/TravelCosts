package ru.s1x6.travelcosts.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import ru.s1x6.travelcosts.budget.BudgetItem;
import ru.s1x6.travelcosts.budget.SimpleBudgetItem;
import ru.s1x6.travelcosts.model.Travel;
import ru.s1x6.travelcosts.money.Currency;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.request.DescriptionRequest;
import ru.s1x6.travelcosts.request.TotalSingleExpensesRequest;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@QuarkusTest
class BudgetServiceTest {

    @Inject
    BudgetService budgetService;

    @Test
    public void test() {
        Travel travel = new Travel(LocalDate.now(), Period.of(0, 3, 0), 2);

        BudgetItem foodExpensesItem = new SimpleBudgetItem("Еда",
                new Money(15000.0, Currency.WON),
                ChronoUnit.DAYS,
                true,
                true,
                true
        );
        travel.addBudgetItem(foodExpensesItem);

        List<DescriptionRequest> requests = Collections.singletonList(new TotalSingleExpensesRequest());
        System.out.println(budgetService.describe(travel, requests, Currency.RUB));
    }

}