package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("agent \\d+");
        Matcher m = p.matcher("agent 009");

        boolean found = m.find();
        System.out.println("found: " + found);

        // ### digression ###
        System.out.println("using String method repeat " + "*".repeat(5));
        // ##################

        // Positive Lookahead
        // matches a digit only if it is followed by a non-digit character. For instance, in the string "3a",
        // the digit 3 would match because it is followed by a, which is a non-digit.
        p = Pattern.compile("\\d(?=\\D)");
        m = p.matcher("3a");

        System.out.println("found with pos. lookahead: " + m.find());

        // Negative Lookahead
        // matches a digit only if it is not followed by a capital letter. In the string "3",
        // the digit 3 would match because it is not followed by any character.

        p = Pattern.compile("\\d(?![A-Z])");
        m = p.matcher("3+");

        System.out.println("found with neg. lookahead: " + m.find());

        // Combining Lookaheads
        String regex = "^(?=.*[A-Z])(?=.*[a-z]).+$"; // Complete regex with anchors
        String input = "hello123"; // Example input

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("The string \"" + input + "\" contains at least one uppercase letter and one lowercase letter.");
        } else {
            System.out.println("The string \"" + input + "\" does NOT meet the criteria.");
        }
    }
}