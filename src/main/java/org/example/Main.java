package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Pattern p = Pattern.compile("agent \\d+");
        Matcher m = p.matcher("agent 009");

        boolean found = m.find();

        System.out.println("found: " + found);

        System.out.println("using String method repeat " + "found".repeat(1));

    }
}