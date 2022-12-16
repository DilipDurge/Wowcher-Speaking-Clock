package com.wowcher.speakingclock.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpeakingClockValidator {
    private static final Pattern speakingClockPattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");

    public boolean validClockFormat(String clockTime) {
        Matcher matcher = speakingClockPattern.matcher(clockTime);
        return matcher.matches();
    }

    public boolean validHours(Integer hour) {
        return hour >= 0 && hour <= 23;
    }

    public boolean validMinutes(Integer minute) {
        return minute >= 0 && minute <= 59;
    }
}
