package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.DivisionData;
import dto.DivisionStep;

public class FormatterTest {
    private static final int DIVIDEND = 154;
    private static final int DIVISOR = 4;
    private static final String EXPECTED = ("_154|4" + "\n") +
            (" 12 |--" + "\n") +
            (" -- |38" + "\n") +
            (" _34" + "\n") +
            ("  32" + "\n") +
            ("  --" + "\n") +
            ("   2");
    private DivisionFormatter format;

    DivisionData prepareTestFormatter() {
        int result = DIVIDEND / DIVISOR;
        int rest = DIVIDEND % DIVISOR;
        List<DivisionStep> steps = new ArrayList<>();
        steps.add(new DivisionStep(15, 12));
        steps.add(new DivisionStep(34, 32));
        DivisionData data = DivisionData.builder().withDividend(DIVIDEND).withDivisor(DIVISOR).withRest(rest).withResult(result)
                .withStep(steps).build();
        return data;
    }


    @BeforeEach
    public void init() {
        format = new DivisionFormatter();
    }

    @Test
    void shouldOutputFomatter() {
        DivisionData data = prepareTestFormatter();
        StringBuilder actual = format.format(data);
        String actualString = String.valueOf(actual);
        String expectedString = EXPECTED;
        assertEquals(expectedString, actualString);
    }
}

