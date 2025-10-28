package utils;

public class TimeConverter {
    private static final int SECONDS_PER_MINUTE = 60;

    public double secondsToMinutes(long seconds) {
        validateNonNegative(seconds, "secondsToMinutes");
        return (double) seconds / SECONDS_PER_MINUTE;
    }

    private void validateNonNegative(long value, String name) {
        if(value < 0){throw new IllegalArgumentException(name + " cannot be negative");}
    }
}
