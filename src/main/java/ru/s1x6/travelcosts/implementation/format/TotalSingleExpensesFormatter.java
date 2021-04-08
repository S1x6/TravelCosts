package ru.s1x6.travelcosts.implementation.format;

import ru.s1x6.travelcosts.format.Formatter;
import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.request.DescriptionRequest;
import ru.s1x6.travelcosts.request.TotalSingleExpensesRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TotalSingleExpensesFormatter implements Formatter {
    @Override
    public String format(CalculationResult result) {
        return result.getMoney().toString();
    }

    @Override
    public Class<? extends DescriptionRequest> getRequestType() {
        return TotalSingleExpensesRequest.class;
    }
}
