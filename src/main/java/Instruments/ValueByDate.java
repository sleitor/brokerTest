package Instruments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
public class ValueByDate {
    @Getter
    @Setter
    private LocalDate date;

    @Getter
    @Setter
    private double value;

    @Override
    public String toString() {
        return "{ date: " + getDate() + ", value: " + getValue() + " } ";
    }
}
