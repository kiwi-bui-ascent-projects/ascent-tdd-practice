package tdd.practice.fizzbuzz;

public class FizzBuzz {
    public String get(int i) {
        String result = "";

        if (i % 3 != 0 && i % 5 != 0) {
            result += Integer.toString(i);
        }
        if (i % 3 == 0) {
            result += "Fizz";
        }
        if (i % 5 == 0) {
            result += "Buzz";
        }

        return result;
    }
}
