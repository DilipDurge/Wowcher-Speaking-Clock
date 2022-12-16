package com.wowcher.speakingclock.controller;

import com.wowcher.speakingclock.constants.SpeakingClockConstants;
import com.wowcher.speakingclock.service.SpeakingClockValidator;

/**
 * This class convert the given clock time in words
 */
public class SpeakingClockController {
    private final int hours;
    private final int minutes;
    private SpeakingClockValidator speakingClockValidator;

    private static final String[] TENS_NUM = {
            "o-", "", "twenty ", "thirty ", "forty ", "fifty "
    };

    private static final String[] ONES_NUM = {
            "twelve ", "one ", "two ", "three ", "four ", "five ",
            "six ", "seven ", "eight ", "nine ", "ten ", "eleven ",
            "twelve ", "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ", "nineteen "
    };

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    /**
     * Initializes all required objects.
     *
     * @param  clockTime the initial string hour entered.
     */
    public SpeakingClockController(String clockTime) {

        speakingClockValidator = new SpeakingClockValidator();
        if(!speakingClockValidator.validClockFormat(clockTime)) {
            throw new IllegalArgumentException(SpeakingClockConstants.INVALID_TIME);
        }

        String[] timeNumbers = clockTime.trim().split(":");
        this.hours = Integer.parseInt(timeNumbers[0]);
        this.minutes = Integer.parseInt(timeNumbers[1]);

        if(!speakingClockValidator.validHours(this.hours)){
            throw new IllegalArgumentException(SpeakingClockConstants.INVALID_HOUR);
        }
        if(!speakingClockValidator.validMinutes(this.minutes)){
            throw new IllegalArgumentException(SpeakingClockConstants.INVALID_MINUTE);
        }
    }

    /**
     * Display converted time in words.
     */
    public void display() {

        String timeInWords = convertToWords(this.getHours(), this.getMinutes());

        if (timeInWords.isEmpty()) {
            System.out.println("Unable to convert clock time in words");
        } else {
            System.out.println(timeInWords);
        }
    }

    /**
     * Converts given clock time in words.
     *
     * @param hour hour
     * @param minutes minutes
     * @return the converted time
     */
    private String convertToWords(int hour, int minutes) {

        StringBuilder result = new StringBuilder();

        if (this.getMinutes() == 0) {

            if (this.getHours() == 12) {
                return result.append(SpeakingClockConstants.MID_DAY).toString();
            }

            if (this.getHours() == 24) {
                return result.append(SpeakingClockConstants.MID_NIGHT).toString();
            }

            result.append(SpeakingClockConstants.ITS).append(ONES_NUM[hour % 12]);

        } else if (minutes % 10 == 0) {
            result.append(SpeakingClockConstants.ITS).append(ONES_NUM[hour % 12]).append(TENS_NUM[minutes / 10]);
        } else if (minutes < 10 || minutes > 20) {
            result.append(SpeakingClockConstants.ITS).append(ONES_NUM[hour % 12]).append(TENS_NUM[minutes / 10]).append(ONES_NUM[minutes % 10]);
        } else {
            result.append(SpeakingClockConstants.ITS).append(ONES_NUM[hour % 12]).append(ONES_NUM[minutes]);
        }

        return result.append(amPmAbbreviation(hour, minutes)).toString();
    }

    /**
     * This return AM / PM according to time
     * @param hour
     * @return Am or Pm abbreviation
     */
    private String amPmAbbreviation(Integer hour, Integer minutes) {
        if((hour == 12 || hour == 24) && minutes == 0) return "";
        return hour > 12 ? SpeakingClockConstants.PM : SpeakingClockConstants.AM;
    }
}
