package Instruments;

import lombok.Getter;
import lombok.Setter;

import static utils.DoubleChecker.invalidNumber;

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

    public static boolean validateNumber(ValueByDate valueByDate) {
        return invalidNumber(valueByDate.getValue());
    }

    public abstract void calculate(ValueByDate valueByDate);

    void synchronizedRun(Runnable f) {
        synchronized (lock) {
            f.run();
        }
    }

    public String toString() {
        return getNAME() + " : " + getResult();
    }
}
