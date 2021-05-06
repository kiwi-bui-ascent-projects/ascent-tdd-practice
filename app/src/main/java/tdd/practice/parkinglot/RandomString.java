package tdd.practice.parkinglot;

import java.util.Random;

public class RandomString {
    private static String[] letters = {"a", "b", "c", "d", "e", "f"};

    public static String get() {
        String result = "";

        Random random = new Random();

        result += letters[random.nextInt(6)];

        for (int i = 0; i < 8; i++) {
            // This is inefficient.  Consider using StringBuilder instead
            result += random.nextInt(10);
        }

        return result;
    }
}
