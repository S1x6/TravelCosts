package ru.s1x6.travelcosts.calculation;

import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.model.Travel;
import ru.s1x6.travelcosts.money.Currency;
import ru.s1x6.travelcosts.request.DescriptionRequest;

public interface Calculator {
    CalculationResult calculate(Travel travel, Currency targetCurrency);
    Class<? extends DescriptionRequest> getRequestType();
}
