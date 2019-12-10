package Instruments;

import java.time.LocalDate;
import java.time.YearMonth;

public class Instrument2 extends Instrument1 {
    private final YearMonth period;

    public Instrument2(String NAME, int year, int month) {
        super(NAME);
        period = YearMonth.of(year, month);
    }

    @Override
    public void calculate(double value, LocalDate date) {
        if (date.getMonth().equals(period.getMonth()) && date.getYear() == period.getYear()) {
            super.calculate(value, date);
        }
    }
}
