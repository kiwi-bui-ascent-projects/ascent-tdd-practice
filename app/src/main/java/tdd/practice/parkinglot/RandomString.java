package tdd.practice.parkinglot;

import java.util.Random;

public class RandomString {
    private static String[] letters = {"a", "b", "c", "d", "e", "f"};

    public static String get() {
        Random random = new Random();
        StringBuilder result = new StringBuilder(letters[random.nextInt(6)]);

        for (int i = 0; i < 8; i++) {
            result.append(random.nextInt(10));
        }

        return result.toString();
    }
}
