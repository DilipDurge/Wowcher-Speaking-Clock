package com.wowcher.speakingclock;

import com.wowcher.speakingclock.constants.SpeakingClockConstants;
import com.wowcher.speakingclock.controller.SpeakingClockController;
import org.junit.Assert;
import org.junit.Test;

public class SpeakingClockControllerTest {

    private static final String AlphabetAsInvalidClockFormat = "12:aa";
    private static final String ColonAsInvalidClockFormat = "12;30";
    private static final String InvalidClockNumbers = "14:70";
    private static final String MidDay = "12:00";
    private static final String MidNight = "24:00";
    private static final String ItsOne = "01:00";
    private static final String ItsEightONine = "08:09";
    private static final String Its_One = "It's one";
    private static final String Its_Eight_O_Nine = "It's eight o-nine";
    private static final String AmClockTime = "09:34";
    private static final String PmClockTime = "20:43";

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidFormat_thenThrowsException(){
        SpeakingClockController speakingClock = new SpeakingClockController(AlphabetAsInvalidClockFormat);
        speakingClock.display();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEnteredColonInvalidFormat_thenThrowsException(){
        SpeakingClockController speakingClock = new SpeakingClockController(ColonAsInvalidClockFormat);
        speakingClock.display();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidNumbers_thenThrowsException(){
        SpeakingClockController speakingClock = new SpeakingClockController(InvalidClockNumbers);
        speakingClock.display();
    }

    @Test
    public void testWhenItsMidday() {
        SpeakingClockController speakingClock = new SpeakingClockController(MidDay);
        speakingClock.display();
        Assert.assertEquals(SpeakingClockConstants.MID_DAY, speakingClock);
    }

    @Test
    public void testWhenItsMidnight() {
        SpeakingClockController speakingClock = new SpeakingClockController(MidNight);
        speakingClock.display();
        Assert.assertEquals(SpeakingClockConstants.MID_NIGHT, speakingClock);
    }

    @Test
    public void whenEnteredOne_thenReturnItsOne() {
        SpeakingClockController speakingClock = new SpeakingClockController(ItsOne);
        speakingClock.display();
        Assert.assertEquals(Its_One, speakingClock);
    }

    @Test
    public void whenEnteredEightONine_thenReturnItsEightONine() {
        SpeakingClockController speakingClock = new SpeakingClockController(ItsEightONine);
        speakingClock.display();
        Assert.assertEquals(Its_Eight_O_Nine, speakingClock);
    }

    @Test
    public void testWhenAmOrPM() {
        SpeakingClockController speakingClockAM = new SpeakingClockController(AmClockTime);
        speakingClockAM.display();
        SpeakingClockController speakingClockPM = new SpeakingClockController(PmClockTime);
        speakingClockPM.display();
        Assert.assertEquals(speakingClockAM, speakingClockPM);
    }
}
