package main;

import dto.DivisionData;
import math.Calculator;
import view.DivisionFormatter;

public class Facade {

    public StringBuilder facade(int divider, int dividend) {
        Calculator calculate = new Calculator();
        DivisionData divisionData = calculate.calculate(divider, dividend);
        DivisionFormatter formatter = new DivisionFormatter();
        return formatter.format(divisionData);
    }
}

