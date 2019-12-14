package Instruments;

public class Instrument3 extends Instrument {
    public Instrument3(String NAME) {
        super(NAME);
        setResult(Double.NaN);
    }

    @Override
    public void calculate(ValueByDate valueByDate) {
        if (validateNumber(valueByDate)) return;
        synchronizedRun(() -> {
            double result = getResult();
            if (Double.isNaN(result) || result > valueByDate.getValue()) setResult(valueByDate.getValue());
        });
    }
}
