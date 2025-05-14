package com.example.Manufac.utils;

public class TimeUtils {
    public static String formatTime(double result) {
        int hours = (int) Math.floor(result);
        int minutes = (int) Math.floor((result % 1) * 60);
        int seconds = (int) Math.floor((result % 1) * 3600 % 60);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
