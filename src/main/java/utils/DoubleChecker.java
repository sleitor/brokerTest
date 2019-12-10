package utils;

public class DoubleChecker {
    public static boolean invalidNumber(Double number) {
        return Double.isNaN(number) || number.isInfinite() || number < 0;
    }
}
