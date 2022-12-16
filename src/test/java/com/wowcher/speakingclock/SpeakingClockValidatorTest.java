package com.wowcher.speakingclock;

import com.wowcher.speakingclock.service.SpeakingClockValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeakingClockValidatorTest {
    private static final String ValidClockFormat = "23:20";
    private static final String InvalidClockFormat = "80:70:90";
    private static final Integer ValidHourFormat = 23;
    private static final Integer InvalidHourFormat = 60;
    private static final Integer ValidMinuteFormat = 27;
    private static final Integer InvalidMinuteFormat = 90;
    private SpeakingClockValidator speakingClockValidator;

    @Before
    public void setup() {
        speakingClockValidator = new SpeakingClockValidator();
    }

    @Test
    public void invalidClockFormat() {
        boolean result = speakingClockValidator.validClockFormat(InvalidClockFormat);
        Assert.assertFalse(result);
    }

    @Test
    public void validClockFormat() {
        boolean result = speakingClockValidator.validClockFormat(ValidClockFormat);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidHourFormat() {
        boolean result = speakingClockValidator.validHours(InvalidHourFormat);
        Assert.assertFalse(result);
    }

    @Test
    public void validHourFormat() {
        boolean result = speakingClockValidator.validHours(ValidHourFormat);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidMinuteFormat() {
        boolean result = speakingClockValidator.validMinutes(InvalidMinuteFormat);
        Assert.assertFalse(result);
    }

    @Test
    public void validMinuteFormat() {
        boolean result = speakingClockValidator.validMinutes(ValidMinuteFormat);
        Assert.assertTrue(result);
    }
}
