package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PWValidation {

    public static boolean isOfMinLength(String PW, int minLength) {
        return PW.length() >= minLength;
    }

    public static boolean containsKDigits(String PW, int minTimes) {

        String patternInput = "\\d.*".repeat(minTimes);

        Pattern p = Pattern.compile(patternInput);
        Matcher m = p.matcher(PW);

        return m.find();


    }




}
