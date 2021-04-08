package ru.s1x6.travelcosts.format;

import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.request.DescriptionRequest;

public interface Formatter {
    String format(CalculationResult result);

    Class<? extends DescriptionRequest> getRequestType();
}
