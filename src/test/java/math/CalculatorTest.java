package math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.DivisionData;
import dto.DivisionStep;

public class CalculatorTest {
    private static final String ONLY_ZERO_CALCULATE = "Divisor cannot be 0, division by zero";
    private static final int DIVIDEND = 154;
    private static final int DIVISOR = 4;
    private static final int ZERO = 0;
    private Calculator calculate;

    DivisionData prepareTestCaclculator() {
        int result = DIVIDEND / DIVISOR;
        int rest = DIVIDEND % DIVISOR;
        List<DivisionStep> steps = new ArrayList<>();
        steps.add(new DivisionStep(15, 12));
        steps.add(new DivisionStep(34, 32));
        DivisionData data = DivisionData.builder()
                .withDividend(DIVIDEND)
                .withDivisor(DIVISOR)
                .withRest(rest)
                .withResult(result)
                .withStep(steps)
                .build();
        return data;
    }

    @BeforeEach
    public void init() {
        calculate = new Calculator();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenDivisorZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculate.calculate(DIVIDEND, ZERO));
        assertEquals(ONLY_ZERO_CALCULATE, exception.getMessage());
    }

    @Test
    void shouldOutputCalculate() {
        DivisionData actual = calculate.calculate(DIVIDEND, DIVISOR);
        DivisionData data = prepareTestCaclculator();
        assertEquals(data, actual);
    }
}

