package ru.s1x6.travelcosts.request;

public class TotalSingleExpensesRequest implements DescriptionRequest {
    @Override
    public String getName() {
        return "Общие суммарные расходы на одного человека";
    }
}
