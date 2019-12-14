package test.broker;

import Instruments.ValueByDate;
import utils.DateChecker;
import utils.InvalidDateException;
import utils.Strings;

import java.time.LocalDate;

public class RowAnalyzer {
    private DateChecker DATE_CHECKER;

    public RowAnalyzer() {
        DATE_CHECKER = new DateChecker();
    }

    public RowAnalyzer(String dateString) {
        DATE_CHECKER = new DateChecker(dateString);
    }

    public ValueByDate parse(String str) {
        String[] strings = Strings.parseString(str, ",");
        LocalDate date = DATE_CHECKER.dateParser(strings[1]);
        if (DATE_CHECKER.isInvalidDate(date)) throw new InvalidDateException();

        return new ValueByDate(date, Double.parseDouble(strings[2]), strings[0]);
    }
}
