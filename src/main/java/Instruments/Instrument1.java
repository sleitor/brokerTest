package Instruments;

import lombok.Getter;

public class Instrument1 extends Instrument {
    @Getter
    private long count;

    public Instrument1(String NAME) {
        super(NAME);
    }

    @Override
    public void calculate(ValueByDate valueByDate) {
        if (validateNumber(valueByDate)) return;
        synchronizedRun(() -> {
            setResult((getResult() * count + valueByDate.getValue()) / (count + 1));
            count++;
        });
    }

    @Override
    public String toString() {
        return super.toString() + " matched count: " + getCount();
    }

}
