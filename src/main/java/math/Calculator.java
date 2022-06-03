package math;

import java.util.ArrayList;
import java.util.List;

import dto.DivisionData;
import dto.DivisionStep;

public class Calculator {

    public DivisionData calculate(int dividend, int divisor) {
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        }
        int[] numbers = arrayToInt(dividend);
        Integer reminderNumber = 0;
        int result = dividend / divisor;
        int rest = dividend % divisor;
        List<DivisionStep> steps = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            reminderNumber = reminderNumber + numbers[i];
            if (reminderNumber >= divisor) {
                int subtrahend = reminderNumber / divisor * divisor;
                int remainder = reminderNumber % divisor;
                steps.add(new DivisionStep(reminderNumber, subtrahend));
                reminderNumber = remainder;
                if (remainder == 0) {
                    reminderNumber = 0;
                }
            }
            reminderNumber = reminderNumber * 10;
        }
        DivisionData data = DivisionData.builder()
                .withDividend(dividend)
                .withDivisor(divisor)
                .withRest(rest)
                .withResult(result)
                .withStep(steps)
                .build();
        return data;
    }

    public int[] arrayToInt(int number) {
        int amountMove = String.valueOf(number).length();
        int[] result = new int[amountMove];
        for (int i = 0; i < amountMove; i++) {
            result[i] = (int) (number / Math.pow(10, amountMove - 1 - i));
            number = (int) (number - result[i] * Math.pow(10, amountMove - 1 - i));
        }
        return result;
    }
}
