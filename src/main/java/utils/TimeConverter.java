package utils;

public class TimeConverter {
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;

    private void validateNonNegative(long value, String name) {
        if(value < 0){throw new IllegalArgumentException(name + " cannot be negative");}
    }

    public double secondsToMinutes(long seconds) {
        validateNonNegative(seconds, "secondsToMinutes");
        return seconds / (double) SECONDS_PER_MINUTE;
    }

    public long minutesToSeconds(double minutes) {
        validateNonNegative((long)minutes, "secondsToMinutes");
        return Math.round(SECONDS_PER_MINUTE * minutes);
    }

    public double minutesToHours(long minutes) {
        return minutes / (double) MINUTES_PER_HOUR;
    }

    public long hoursToMinutes(double hours) {
        return Math.round(hours * MINUTES_PER_HOUR);
    }

    public double hoursToDays(long hours) {
        return hours / (double) HOURS_PER_DAY;
    }

    public long daysToHours(double days) {
        return 24;
    }
}
