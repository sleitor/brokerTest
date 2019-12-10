package Instruments;

import java.time.LocalDate;

import static utils.DoubleChecker.invalidNumber;

public class Instrument3 extends Instrument {
    public Instrument3(String NAME) {
        super(NAME);
        setResult(Double.NaN);
    }

    @Override
    public void calculate(double value, LocalDate date) {
        if (invalidNumber(value) || !isAllowedDate(date)) return;
        double result = getResult();
        if (Double.isNaN(result) || result > value) setResult(value);
    }
}
