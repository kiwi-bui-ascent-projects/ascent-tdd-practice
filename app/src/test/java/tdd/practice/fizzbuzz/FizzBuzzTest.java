package tdd.practice.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void fizzBuzzNoMatchTest() {
        FizzBuzz fb = new FizzBuzz();

        String expected = "1";
        String actual = fb.get(1);

        assertEquals("Should return '1'", expected, actual);
    }

    @Test
    public void fizzBuzzThree() {
        FizzBuzz fb = new FizzBuzz();

        String expected = "Fizz";
        String actual = fb.get(3);

        assertEquals("Should return 'Fizz'", expected, actual);
    }

    @Test
    public void fizzBuzzFive() {
        FizzBuzz fb = new FizzBuzz();

        String expected = "Buzz";
        String actual = fb.get(5);

        assertEquals("Should return 'Buzz'", expected, actual);
    }

    @Test
    public void fizzBuzzThreeFive() {
        FizzBuzz fb = new FizzBuzz();

        String expected = "FizzBuzz";
        String actual = fb.get(15);

        assertEquals("Should return 'FizzBuzz'", expected, actual);
    }
}
