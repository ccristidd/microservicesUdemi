package com.tutorial.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String regexStr = ".*[a-z][0-9].";
        Pattern pattern = Pattern.compile(regexStr);

        Matcher matcher = pattern.matcher("1234567890abcdefggijklmnopqrestuv1235654564321");
        Matcher matcher1 = pattern.matcher("1235fdfafsa43242adfsaf");
        boolean matchFound = matcher1.find();
        if (matchFound) {
            System.out.println("Match Found!!");
        } else {
            System.out.println("Match not found!");
        }
        System.out.println(matcher1.find());
    }
}
