package ru.s1x6.travelcosts.request;

public class FirstMonthSingleExpensesRequest implements DescriptionRequest {
    @Override
    public String getName() {
        return "Сумма денег, необходимая на первый месяц на одного";
    }
}
