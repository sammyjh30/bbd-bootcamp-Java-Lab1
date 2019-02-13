package com.bbd.pingpong;

import java.util.HashMap;
import java.util.Map;

public class RomanConverter {
    public static int convert(String s) {
//        Dictionary numerals = new Hashtable();
        Map<String, Integer> numerals = new HashMap<String, Integer>();

        int ret = 0;
        // add Roman numerals
        numerals.put("I", 1);
        numerals.put("V", 5);
        numerals.put("X", 10);
        numerals.put("L", 50);
        numerals.put("C", 100);
        numerals.put("D", 500);
        numerals.put("M", 1000);

        s = s.toUpperCase();

        if (!s.matches("[IVXLCDM]+")) {
            throw new IllegalArgumentException();
        }
        String letter = "";
        String nextLetter = "";
        for (int i = 0; i < s.length(); i++) {
            letter = "";
            letter += s.charAt(i);
            if (i + 1 < s.length()) {
                nextLetter = "";
                nextLetter += s.charAt(i + 1);
            }
            if ( i + 3 < s.length()){
                if ( !letter.equals("M") && s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2) && s.charAt(i) == s.charAt(i + 3))
                    throw new IllegalArgumentException();
            }

            if (nextLetter.length() > 0 && numerals.get(letter) < numerals.get(nextLetter)) {
                if (letter.equals("I") && !nextLetter.equals("V") && !nextLetter.equals("X")) {
                    throw new IllegalArgumentException();
                } else if (letter.equals("V") || letter.equals("L") || letter.equals("D")) {
                    throw new IllegalArgumentException();
                } else if (letter.equals("X") && !nextLetter.equals("L") && !nextLetter.equals("C")) {
                    throw new IllegalArgumentException();
                } else if (letter.equals("C") && !nextLetter.equals("D") && !nextLetter.equals("M")) {
                    throw new IllegalArgumentException();
                }
                else {
                    ret = ret + (numerals.get(nextLetter) - numerals.get(letter));
                    i++;
                }
            } else
                ret += numerals.get(letter);

        }
        return ret;
    }
}