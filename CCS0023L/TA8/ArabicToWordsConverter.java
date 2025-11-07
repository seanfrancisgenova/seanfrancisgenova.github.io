package TA8;

import java.util.Scanner;

public class ArabicToWordsConverter {

    private static final String[] ones = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convertToWords(int num) {
        if (num == 0)
            return "Zero";
        if (num < 0)
            return "Negative numbers are not supported.";
        if (num > 3999)
            throw new IllegalArgumentException("ERROR: Number out of range (1-3999).");

        String words = "";

        if (num / 1000 > 0) {
            words += ones[num / 1000] + " Thousand ";
            num %= 1000;
        }

        if (num / 100 > 0) {
            words += ones[num / 100] + " Hundred ";
            num %= 100;
        }

        if (num > 0) {
            if (num < 20)
                words += ones[num];
            else {
                words += tens[num / 10];
                if (num % 10 > 0)
                    words += "-" + ones[num % 10];
            }
        }

        return words.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Arabic Numbers to Words Converter ===");
        System.out.println("Valid Range: 1-3999");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            System.out.print("Enter a number: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            try {

                if (!input.matches("\\d+"))
                    throw new NumberFormatException("ERROR: Input must contain digits only.");

                int number = Integer.parseInt(input);

                if (number < 1 || number > 3999)
                    throw new IllegalArgumentException("ERROR: Number out of range (1–3999).");
                String result = convertToWords(number);
                System.out.println(number + " = " + result);
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
            finally {
                System.out.println("(Operation complete)\n");
            }
        }

        sc.close();
    }
}

