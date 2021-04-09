package ru.s1x6.travelcosts.format;

import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.request.DescriptionRequest;

import java.time.temporal.ChronoUnit;

public interface Formatter {
    String format(String title, CalculationResult result);

    Class<? extends DescriptionRequest> getRequestType();

    default void appendPer(ChronoUnit chronoUnit, CalculationResult result, StringBuilder sb) {
        Money convertedMoney = result.convertTo(chronoUnit);
        sb.append("\tили ")
                .append(convertedMoney.getValue())
                .append(" ").append(convertedMoney.getCurrency())
                .append(" за 1 ").append(chronoUnit)
                .append("\n");
    }
}
