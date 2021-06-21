package tdd.practice.romantodecimal;

import java.util.HashMap;

public class RomanToDecimal {
    private final HashMap<Character, Integer> numerals = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int get(String input) {
        int result = 0;
        int length = input.length();

        for (int i = 0; i < length; i++) {
            int current = numerals.get(input.charAt(i));
            int next = (i == length - 1) ? numerals.get(input.charAt(i)) : numerals.get(input.charAt(i + 1));

            if (next > current) {
                result += next - current;
                i++;
            } else {
                result += current;
            }
        }

        return result;
    }
}