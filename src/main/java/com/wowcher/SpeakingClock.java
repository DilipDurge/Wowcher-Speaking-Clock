package com.wowcher.speakingclock;

import com.wowcher.speakingclock.controller.SpeakingClockController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeakingClock {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the 24 hour format you want to be converted into words: ");
        String clockTime = reader.readLine();

        SpeakingClockController speakingClock = new SpeakingClockController(clockTime);
        speakingClock.display();
    }
}