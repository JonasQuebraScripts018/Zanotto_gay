package com.example.demo.Service;

public class S_NumberCleaner {
    public static String cleanerNumber(String number){
        return number.replaceAll("[^0-9]", "");
    }
}
