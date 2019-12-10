package Instruments;

import java.time.LocalDate;

public class Instrument3 extends Instrument {
    public Instrument3(String NAME) {
        super(NAME);
        setResult(Double.NaN);
    }

    @Override
    public void calculate(double value, LocalDate date) {
        if (Double.isNaN(getResult()) || getResult() > value) setResult(value);
    }
}
