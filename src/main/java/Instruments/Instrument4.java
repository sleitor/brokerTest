package Instruments;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static utils.DoubleChecker.invalidNumber;

public class Instrument4 extends Instrument {
    private final ReadWriteLock locks = new ReentrantReadWriteLock();
    private final AtomicReferenceArray<ValueByDate> lastValueByDate;

    public Instrument4(String NAME) {
        this(NAME, 10);
    }

    public Instrument4(String NAME, int capacity) {
        super(NAME);
        lastValueByDate = new AtomicReferenceArray<>(new ValueByDate[capacity]);
        for (int i = 0, lastValueByDateLength = lastValueByDate.length(); i < lastValueByDateLength; i++) {
            lastValueByDate.set(i, new ValueByDate(LocalDate.MIN, 0));
        }
    }

    @Override
    public void calculate(double value, LocalDate date) {
        if (invalidNumber(value) || !isAllowedDate(date)) return;
        int minDateIndex = -1;

        LocalDate minDate = LocalDate.MAX;
        double sum = 0;

        for (int i = 0, lastValueByDateLength = lastValueByDate.length(); i < lastValueByDateLength; i++) {
            boolean after;
            locks.readLock().lock();
            try {
                ValueByDate valueByDate = lastValueByDate.get(i);
                LocalDate date1 = valueByDate.getDate();
                if (minDate.isAfter(date1)) {
                    minDate = date1;
                    minDateIndex = i;
                }
                sum += valueByDate.getValue();

                after = date.isAfter(lastValueByDate.get(minDateIndex).getDate());
            } finally {
                locks.readLock().unlock();
            }

            if (after) {

                locks.writeLock().lock();
                try {
                    sum = sum + (value - lastValueByDate.get(minDateIndex).getValue());
                    lastValueByDate.get(minDateIndex).setDate(date);
                    lastValueByDate.get(minDateIndex).setValue(value);
                } finally {
                    locks.writeLock().unlock();
                }
            }

            setResult(sum);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lastValueByDate.length(); i++) {
            if (lastValueByDate.get(i).getDate().getYear() > 0) str.append(" ").append(lastValueByDate.get(i));
        }
        return super.toString() + str;
    }
}
