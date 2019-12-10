package Instruments;

import lombok.Getter;

import java.time.LocalDate;

public class Instrument1 extends Instrument {
    @Getter
    private long count;

    public Instrument1(String NAME) {
        super(NAME);
    }

    @Override
    public void calculate(double value, LocalDate date) {
        if (isAllowedDate(date)) {
            setResult((getResult() * count + value) / (count + 1));
            count++;
        }
    }

    @Override
    public String toString() {
        return getNAME() + " : " + getResult() + " matched count: " + getCount();
    }

}
