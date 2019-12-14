package Instruments;

import java.time.YearMonth;

public class Instrument2 extends Instrument1 {
    private final YearMonth period;

    public Instrument2(String NAME, int year, int month) {
        super(NAME);
        period = YearMonth.of(year, month);
    }

    @Override
    public void calculate(ValueByDate valueByDate) {
        if (valueByDate.getDate().getMonth().equals(period.getMonth()) && valueByDate.getDate().getYear() == period.getYear()) {
            super.calculate(valueByDate);
        }
    }
}
