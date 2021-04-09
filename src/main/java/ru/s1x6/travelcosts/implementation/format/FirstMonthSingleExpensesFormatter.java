package ru.s1x6.travelcosts.implementation.format;

import ru.s1x6.travelcosts.format.Formatter;
import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.request.DescriptionRequest;
import ru.s1x6.travelcosts.request.FirstMonthSingleExpensesRequest;

import javax.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class FirstMonthSingleExpensesFormatter implements Formatter {

    @Override
    public String format(String title, CalculationResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append(":\n\t")
                .append(result.getMoney().getValue()).append(" ")
                .append(result.getMoney().getCurrency()).append(", ")
                .append("за 1 Months");
        long between = ChronoUnit.DAYS.between(result.getDatePeriod().getStartDate(),
                result.getDatePeriod().getStartDate().plusMonths(1));
        sb.append(" (").append(between).append(" дней в сумме)\n");
        //надо умножать

        appendPer(ChronoUnit.WEEKS, result, sb);
        appendPer(ChronoUnit.DAYS, result, sb);
        return sb.toString();
    }

    @Override
    public Class<? extends DescriptionRequest> getRequestType() {
        return FirstMonthSingleExpensesRequest.class;
    }
}
