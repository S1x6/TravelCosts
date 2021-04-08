package ru.s1x6.travelcosts.service;

import ru.s1x6.travelcosts.calculation.Calculator;
import ru.s1x6.travelcosts.format.Formatter;
import ru.s1x6.travelcosts.model.CalculationResult;
import ru.s1x6.travelcosts.model.Travel;
import ru.s1x6.travelcosts.money.Currency;
import ru.s1x6.travelcosts.request.DescriptionRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class BudgetService {

    private final Map<Calculator, Formatter> calculatorMap = new HashMap<>();

    @Inject
    public BudgetService(Instance<Calculator> calculators,
                         Instance<Formatter> formatters) {
        calculators.stream().forEach(calculator -> {
            List<Formatter> list = formatters.stream()
                    .filter(formatter -> formatter.getRequestType().equals(calculator.getRequestType()))
                    .collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new RuntimeException("No formatter found for " + calculator.getClass().getCanonicalName());
            }
            if (list.size() > 1) {
                throw new RuntimeException("Ambiguous formatters for " + calculator.getClass().getCanonicalName());
            }
            calculatorMap.put(calculator, list.get(0));
        });
    }

    public String describe(Travel travel, List<DescriptionRequest> descriptionRequests, Currency targetCurrency) {
        StringBuilder sb = new StringBuilder();
        calculatorMap.forEach((calculator, formatter) -> {
            if (descriptionRequests.stream().noneMatch(it -> it.getClass().equals(calculator.getRequestType()))) {
                return;
            }
            CalculationResult calculationResult = calculator.calculate(travel, targetCurrency);
            sb.append(formatter.format(calculationResult));
            sb.append("\n");
        });
        return sb.toString();
    }

}
