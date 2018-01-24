package com.bbd.pingpong;

import java.util.ArrayList;
import java.util.List;

public class RomanConverter {

    private static boolean isOrderCorrect(List<Integer> romanNumbers) {
        for (int i = 1; i < romanNumbers.size(); i++) {
            if (romanNumbers.get(i) > romanNumbers.get(i - 1)) {
               return false;
            }
        }

        return true;
    }

    private static List<Integer> toRomanNumbersList(String romanStr) {
        List<Integer> romanInts = new ArrayList<Integer>();

        for (int i = 0; i < romanStr.length(); i++) {
            switch (romanStr.charAt(i)) {
                case 'I':
                    romanInts.add(1);
                    break;
                case 'V':
                    romanInts.add(5);
                    break;
                case 'X':
                    romanInts.add(10);
                    break;
                case 'L':
                    romanInts.add(50);
                    break;
                case 'C':
                    romanInts.add(100);
                    break;
                case 'D':
                    romanInts.add(500);
                    break;
                case 'M':
                    romanInts.add(1000);
                    break;
                default:
                    throw (new IllegalArgumentException("Unknown or Invalid roman character: " + romanStr.charAt(i)));
            }
        }

        return romanInts;
    }

    public static int Convert(String s) {
       if (s == null || s.isEmpty())  {
           throw (new IllegalArgumentException("Not a valid roman"));
       }

        // Handle upper case and lower case
        s = s.toUpperCase();

        int sum = 0;

        // 4 or more in a row of the Roman numerals are in valid (unless we say it is okay below)
        if (s.matches("I{4,}|V{4,}|X{4,}|L{4,}|C{4,}|D{4,}|M{4,}")) {
            throw (new IllegalArgumentException("Not a valid roman"));
        }

        // Replace the exceptions with their equivalents so we don't do subtraction rule.
        s = s.replaceAll("IV", "IIII");
        s = s.replaceAll("IX", "VIIII");
        s = s.replaceAll("XL", "XXXX");
        s = s.replaceAll("XC", "LXXXX");
        s = s.replaceAll("CD", "CCCC");
        s = s.replaceAll("CM", "DCCCC");


        List<Integer> romanNumbers = toRomanNumbersList(s);
        if(!isOrderCorrect(romanNumbers)) {
            throw (new IllegalArgumentException("Not a valid roman"));
        }

        return romanNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}