package TA8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}

class InvalidRomanException extends Exception {
    public InvalidRomanException(String message) {
        super(message);
    }
}

class NonNumericException extends Exception {
    public NonNumericException(String message) {
        super(message);
    }
}

public class RomanArabicConverterWithException {

    private static final Map<Character, Integer> ROMAN_MAP = new HashMap<>();
    static {
        ROMAN_MAP.put('I', 1);
        ROMAN_MAP.put('V', 5);
        ROMAN_MAP.put('X', 10);
        ROMAN_MAP.put('L', 50);
        ROMAN_MAP.put('C', 100);
        ROMAN_MAP.put('D', 500);
        ROMAN_MAP.put('M', 1000);
    }

    private static final int[] VALUES = 
        {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = 
        {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Arabic ↔ Roman Numeral Converter (with Exception Handling) ===");
        System.out.println("Enter 'A' for Arabic → Roman, or 'R' for Roman → Arabic. Type 'Q' to quit.\n");

        try {
            while (true) {
                System.out.print("> ");
                String input = sc.nextLine().trim();

                if (input.equalsIgnoreCase("Q")) {
                    System.out.println("Exiting program...");
                    break;
                }

                char mode = Character.toUpperCase(input.charAt(0));
                    String value = "";

                    if (input.length() == 1) {
    
                        System.out.print("Enter value: ");
                        value = sc.nextLine().trim();
                    } else {
                        value = input.substring(1).trim();
                    }

                try {
                    if (mode == 'A') {

                        int number = parseArabic(value);
                        String roman = arabicToRoman(number);
                        System.out.println(number + " = " + roman);
                    } else if (mode == 'R') {

                        int arabic = romanToArabic(value);
                        System.out.println(value.toUpperCase() + " = " + arabic);
                    } else {
                        System.out.println("ERROR: Unknown mode. Use 'A' or 'R'.");
                    }
                } 
                catch (OutOfRangeException | NonNumericException | InvalidRomanException e) {
                    System.out.println("ERROR: " + e.getMessage());
                } 
                catch (Exception e) {
                    System.out.println("ERROR: Unexpected exception: " + e.getMessage());
                } 
                finally {

                    System.out.println("(Operation complete)\n");
                }
            }
        } 
        finally {
            sc.close();
        }
    }


    public static int parseArabic(String input) throws NonNumericException, OutOfRangeException {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NonNumericException("Non-numeric input. Please enter a valid number.");
        }
        if (num < 1 || num > 3999) {
            throw new OutOfRangeException("Number out of range (1–3999).");
        }
        return num;
    }


    public static String arabicToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (num >= VALUES[i]) {
                sb.append(SYMBOLS[i]);
                num -= VALUES[i];
            }
        }
        return sb.toString();
    }


    public static int romanToArabic(String roman) throws InvalidRomanException {
        roman = roman.toUpperCase();
        if (!roman.matches("[IVXLCDM]+")) {
            throw new InvalidRomanException("Invalid Roman numeral characters detected.");
        }

        int total = 0;
        int i = 0;
        while (i < roman.length()) {
            int value1 = ROMAN_MAP.get(roman.charAt(i));
            int value2 = 0;

            if (i + 1 < roman.length()) {
                value2 = ROMAN_MAP.get(roman.charAt(i + 1));
            }

            if (value1 < value2) {

                String pair = "" + roman.charAt(i) + roman.charAt(i + 1);
                if (!isValidPair(pair)) {
                    throw new InvalidRomanException("Invalid subtractive pair: " + pair);
                }
                total += (value2 - value1);
                i += 2;
            } else {
                total += value1;
                i++;
            }
        }

        if (total < 1 || total > 3999) {
            throw new InvalidRomanException("Roman numeral value out of range (1–3999).");
        }

        String canonical = arabicToRoman(total);
        if (!canonical.equals(roman)) {
            throw new InvalidRomanException("Non-canonical or improperly formatted Roman numeral.");
        }

        return total;
    }

    private static boolean isValidPair(String pair) {
        return pair.equals("IV") || pair.equals("IX") ||
               pair.equals("XL") || pair.equals("XC") ||
               pair.equals("CD") || pair.equals("CM");
    }
}
