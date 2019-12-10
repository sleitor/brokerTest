package Instruments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static utils.DateChecker.isWeekEndCheck;

public abstract class Instrument {
    @Getter
    private final String NAME;
    @Getter
    @Setter
    private double result;

    public Instrument(String NAME) {
        this.NAME = NAME;
    }

    protected static boolean isAllowedDate(LocalDate date) {
        return !isWeekEndCheck(date.getDayOfWeek());
    }

    public abstract void calculate(double value, LocalDate date);

    public String toString() {
        return getNAME() + " : " + getResult();
    }
}
