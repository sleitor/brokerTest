package Instruments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static utils.IsWeekEnd.IsWeekEndCheck;

public abstract class Instrument {
    @Getter
    private final String NAME;
    @Getter
    @Setter
    private double result;

    public Instrument(String NAME) {
        this.NAME = NAME;
    }

    protected boolean isAllowedDate(LocalDate date) {
        return !IsWeekEndCheck(date.getDayOfWeek());
    }

    public abstract void calculate(double value, LocalDate date);

    public String toString() {
        return getNAME() + " : " + getResult();
    }
}
