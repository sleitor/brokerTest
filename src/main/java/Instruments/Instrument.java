package Instruments;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static utils.DateChecker.isWeekEndCheck;

public abstract class Instrument {
    private final Object lock = new Object();

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

    void calc(Runnable f) {
        synchronized (lock) {
            f.run();
        }
    }

    public String toString() {
        return getNAME() + " : " + getResult();
    }
}
