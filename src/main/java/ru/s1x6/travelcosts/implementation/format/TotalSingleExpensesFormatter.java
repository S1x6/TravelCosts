package ru.s1x6.travelcosts.implementation.format;

import ru.s1x6.travelcosts.format.Formatter;
import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.money.Money;
import ru.s1x6.travelcosts.request.DescriptionRequest;
import ru.s1x6.travelcosts.request.TotalSingleExpensesRequest;

import javax.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class TotalSingleExpensesFormatter implements Formatter {
    @Override
    public String format(String title, CalculationResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append(title)
                .append(":\n\t")
                .append(result.getMoney().getValue()).append(" ")
                .append(result.getMoney().getCurrency()).append(", ")
                .append("за ");
        result.getDatePeriod().getPeriod().getUnits().forEach(unit ->
                sb.append(result.getDatePeriod().getPeriod().get(unit)).append(" ").append(unit).append(", "));
        sb.delete(sb.length() - 3, sb.length() - 1);
        sb.append("(").append(result.getDatePeriod().toDays()).append(" дней в сумме)");
        sb.append("\n");

        appendPer(ChronoUnit.MONTHS, result, sb);
        appendPer(ChronoUnit.WEEKS, result, sb);
        appendPer(ChronoUnit.DAYS, result, sb);

        return sb.toString();
    }

    @Override
    public Class<? extends DescriptionRequest> getRequestType() {
        return TotalSingleExpensesRequest.class;
    }
}
