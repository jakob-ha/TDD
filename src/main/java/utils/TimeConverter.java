package utils;

public class TimeConverter {
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MINUTES_PER_HOUR = SECONDS_PER_MINUTE * 60;
    private static final int HOURS_PER_DAY = MINUTES_PER_HOUR * 24;


    public double secondsToMinutes(long seconds) {
        validateNonNegative(seconds, "secondsToMinutes");
        return (double) seconds / SECONDS_PER_MINUTE;
    }

    private void validateNonNegative(long value, String name) {
        if(value < 0){throw new IllegalArgumentException(name + " cannot be negative");}
    }

    public long minutesToSeconds(double minutes) {
        return (long) ((long) SECONDS_PER_MINUTE * minutes);
    }
}
