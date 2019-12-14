package Instruments;

import java.time.LocalDate;

public class Instrument4 extends Instrument {
    private ValueByDate[] lastValueByDate;
    private int minDateIndex;

    public Instrument4(String NAME) {
        this(NAME, 10);
    }

    public Instrument4(String NAME, int capacity) {
        super(NAME);
        lastValueByDate = new ValueByDate[capacity];
        for (int i = 0, lastValueByDateLength = lastValueByDate.length; i < lastValueByDateLength; i++) {
            lastValueByDate[i] = new ValueByDate(LocalDate.MIN, 0, "");
        }
    }

    @Override
    public void calculate(ValueByDate valueByDate) {
        if (validateNumber(valueByDate)) return;

        synchronizedRun(() -> {
            LocalDate minDate = LocalDate.MAX;
            double sum = 0;

            for (int i = 0, lastValueByDateLength = lastValueByDate.length; i < lastValueByDateLength; i++) {
                if (minDate.isAfter(lastValueByDate[i].getDate())) {
                    minDate = lastValueByDate[i].getDate();
                    minDateIndex = i;
                }
                sum += lastValueByDate[i].getValue();
            }

            if (valueByDate.getDate().isAfter(lastValueByDate[minDateIndex].getDate())) {
                sum = sum + (valueByDate.getValue()) - lastValueByDate[minDateIndex].getValue();
                lastValueByDate[minDateIndex].setDate(valueByDate.getDate());
                lastValueByDate[minDateIndex].setValue(valueByDate.getValue());
            }

            setResult(sum);
        });
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (ValueByDate valueByDate : lastValueByDate) {
            if (valueByDate.getDate().getYear() > 0) str.append(" ").append(valueByDate);
        }
        return super.toString() + str;
    }
}
