package view;

import dto.DivisionData;

public class DivisionFormatter implements Formatter {
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String LINE = "_";
    private static final String STICK = "|";
    private static final String ENTER = "\n";
    private static final String EMPTY = "";

    public StringBuilder format(DivisionData data) {
        StringBuilder result = new StringBuilder();
        int lengthDividend = String.valueOf(data.getDividend()).length();
        int lengthRest = String.valueOf(data.getRest()).length();
        int amountSpace = 0;
        result.append(getDivisionHeader(data));
        for (int i = 1; i < data.getSteps().size(); i++) {
            int lengthSubtrahend = String.valueOf(data.getSteps().get(i).getSubtrahend()).length();
            int lengthMinuend = String.valueOf(data.getSteps().get(i).getReminderNumber()).length();
            int difference = lengthMinuend - lengthSubtrahend;
            int intermediateResult = data.getSteps().get(i - 1).getReminderNumber()
                    - data.getSteps().get(i - 1).getSubtrahend();
            int lengthIntermediate = String.valueOf(intermediateResult).length();
            int length = String.valueOf(data.getSteps().get(i - 1).getReminderNumber()).length();
            if (data.getSteps().get(i - 1).getSubtrahend() == data.getSteps().get(i - 1).getReminderNumber()) {
                amountSpace = amountSpace + length;
            } else {
                amountSpace = amountSpace + length - lengthIntermediate;
            }
            result.append(multiplySymbol(amountSpace, SPACE))
                    .append(LINE)
                    .append(data.getSteps().get(i).getReminderNumber())
                    .append(ENTER);
            result.append(multiplySymbol(amountSpace + difference + 1, SPACE))
                    .append(data.getSteps().get(i).getSubtrahend())
                    .append(ENTER);
            result.append(multiplySymbol(amountSpace + 1, SPACE))
                    .append(multiplySymbol(lengthMinuend, DASH))
                    .append(ENTER);
        }
        result.append(multiplySymbol(lengthDividend - lengthRest + 1, SPACE))
                .append(data.getRest());
        return result;
    }

    StringBuilder getDivisionHeader(DivisionData data) {
        StringBuilder result = new StringBuilder();
        int lengthSubtrahend = String.valueOf(data.getSteps().get(0).getSubtrahend()).length();
        int lengthMinuend = String.valueOf(data.getSteps().get(0).getReminderNumber()).length();
        int difference = lengthMinuend - lengthSubtrahend;
        int lengthResult = String.valueOf(data.getResult()).length();
        int lengthDividend = String.valueOf(data.getDividend()).length();
        result.append(LINE)
                .append(data.getDividend())
                .append(STICK)
                .append(data.getDivisor())
                .append(ENTER);
        result.append(multiplySymbol(difference + 1, SPACE))
                .append(data.getSteps().get(0).getSubtrahend())
                .append(multiplySymbol(lengthDividend - lengthSubtrahend, SPACE))
                .append(STICK)
                .append(multiplySymbol(lengthResult, DASH))
                .append(ENTER);
        result.append(SPACE)
                .append(multiplySymbol(lengthMinuend, DASH))
                .append(multiplySymbol(lengthDividend - lengthSubtrahend, SPACE))
                .append(STICK)
                .append(data.getResult())
                .append(ENTER);
        return result;
    }

    String multiplySymbol(int amount, String symbol) {
        String result = EMPTY;
        for (int i = 0; i < amount; i++) {
            result = result + symbol;
        }
        return result;
    }
}

