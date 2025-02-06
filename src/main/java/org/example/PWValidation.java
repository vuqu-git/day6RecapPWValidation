package org.example;

//import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PWValidation {

    // alternative: read in of some csf file
    private static final List<String> weakPasswords = Arrays.asList(
            "qwertz",
            "qwerty",
            "Password1",
            "Aa345678"
    );

    private static final int minNumberOfDigits = 2;


    public static boolean isOfMinLength(String pw, int minLength) {
        return pw.length() >= minLength;
    }

    public static boolean containsKDigits(String pw, int minTimes) {

        // simple regex
        //String regex = "\\d.*".repeat(minTimes);

        // advanced ".*(\\d.*){k}"
        // parameterized with a concrete value for k (=minimum time of digit occurrences)
        String regex = ".*(\\d.*){" + minTimes + ",}.*";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pw);

        return m.find();
    }

    public static boolean containsLowerAndUpperCase(String pw) {

        String regex = "^(?=.*[A-Z])(?=.*[a-z]).+$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pw);

        return m.matches();

//        // very simple approach with simple regex patterns
//        Pattern p1 = Pattern.compile("[A-Z]+");
//        Matcher m1 = p1.matcher(pw);
//
//        Pattern p2 = Pattern.compile("[a-z]+");
//        Matcher m2 = p2.matcher(pw);
//
//        return m1.find() && m2.find();
    }

    public static boolean isWeakPW(String pw) {
        return weakPasswords.stream().anyMatch(pwInStream -> pwInStream.equals(pw));
    }

    public static boolean containsSpecialChar(String PW) {

        Pattern p = Pattern.compile("[^0-9a-zA-Z]+");
        Matcher m = p.matcher(PW);

        return m.find();
    }

    public static char getRandomCharacter() {
        // helper function to generate one random character
        Random random = new Random();

        //int randomASCII = random.nextInt(95) + 32; // Printable ASCII from space (32) to ~ (126)
        int randomASCII = random.nextInt(94) + 33; // without space, starting ! (33) to ~ (126)
        return (char) randomASCII;
    }

    public static String getRandomPW() {

        String randomPW;

        // this line ensures that the password will have min length 8 and max length 30-1+8
        int randomLength = new Random().nextInt(30)+8;

        do {
            List<Character> passwordAsList = Arrays.asList(new Character[randomLength]);
            randomPW = passwordAsList
                    .stream()
                    .map(c -> getRandomCharacter())
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        } while (!containsKDigits(randomPW, minNumberOfDigits) && !containsLowerAndUpperCase(randomPW) && isWeakPW(randomPW));

        return randomPW;
    }

    public static void main(String[] args) {
        System.out.println(getRandomPW());
    }

}
