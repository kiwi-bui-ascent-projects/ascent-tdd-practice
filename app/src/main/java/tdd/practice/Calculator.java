package tdd.practice;

public class Calculator {
    public int add(String input) throws NegativeNumbersException {
        int sum = 0;
        String negatives = "";

        if (input != "") {
            String delimiters = ",|\n";

            if (input.charAt(0) == '/') {
                delimiters += "|" + Character.toString(input.charAt(2));
                input = input.substring(4);
            }

            String[] inputs = input.split(delimiters);
            for (String number : inputs) {
                if (number.charAt(0) == '-') {
                    negatives += String.format(" %s,", number);
                } else {
                    sum += Integer.valueOf(number);
                }
            }
        }

        if (negatives != "") {
            throw new NegativeNumbersException("negatives not allowed:" +
                    negatives.substring(0, negatives.length() - 1));
        } else {
            return sum;
        }
    }
}
