package ru.s1x6.travelcosts.service;

import ru.s1x6.travelcosts.calculation.AbstractCalculator;
import ru.s1x6.travelcosts.model.Travel;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Map;

@ApplicationScoped
public class BudgetService {

    private Map<String, AbstractCalculator> calculatorMap;

    @Inject
    public BudgetService(Instance<AbstractCalculator> calculators) {
        calculators.stream().forEach(calculator -> {
//            if (calculatorMap.putIfAbsent(, calculator) != null) {
//
//            }
        });
    }

    public void describe(Travel travel) {

    }

}
