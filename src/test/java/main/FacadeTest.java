package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import dto.DivisionData;
import dto.DivisionStep;
import math.Calculator;
import view.DivisionFormatter;

@RunWith(MockitoJUnitRunner.class)
public class FacadeTest {
    private static final int DIVIDEND = 154;
    private static final int DIVISOR = 4;
    private static final String EXPECTED = ("_154|4" + "\n") +
            (" 12 |--" + "\n") +
            (" -- |38" + "\n") +
            (" _34" + "\n") +
            ("  32" + "\n") +
            ("  --" + "\n") +
            ("   2");
    Calculator calculateMock = mock(Calculator.class);
    DivisionFormatter formatterMock = mock(DivisionFormatter.class);

    public StringBuilder facade(int DIVIDEND, int DIVISOR) {
        DivisionData data = calculateMock.calculate(DIVIDEND, DIVISOR);
        StringBuilder result = formatterMock.format(data);
        return result;
    }

    DivisionData prepareTestFacade() {
        int result = DIVIDEND / DIVISOR;
        int rest = DIVIDEND % DIVISOR;
        List<DivisionStep> steps = new ArrayList<>();
        steps.add(new DivisionStep(15, 12));
        steps.add(new DivisionStep(34, 32));
        DivisionData data = DivisionData.builder().withDividend(DIVIDEND).withDivisor(DIVISOR).withRest(rest)
                .withResult(result).withStep(steps).build();
        return data;
    }

    @Test
    void testFacade() {
        DivisionData data = prepareTestFacade();
        StringBuilder expected = new StringBuilder().append(EXPECTED);
        when(calculateMock.calculate(DIVIDEND, DIVISOR)).thenReturn(data);
        when(formatterMock.format(data)).thenReturn(expected);
        formatterMock.format(calculateMock.calculate(DIVIDEND, DIVISOR));
        assertEquals(expected, facade(DIVIDEND, DIVISOR));
        InOrder inOrder = Mockito.inOrder(calculateMock, formatterMock);
        inOrder.verify(calculateMock).calculate(DIVIDEND, DIVISOR);
        inOrder.verify(formatterMock).format(data);
        verify(calculateMock, atLeastOnce()).calculate(DIVIDEND, DIVISOR);
        verify(formatterMock, atLeastOnce()).format(data);
    }
}
