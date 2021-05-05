package tdd.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {
    @Test
    public void calculatorEmptyStringTest() throws NegativeNumbersException {
        Calculator calc = new Calculator();

        int expected = 0;
        int actual = calc.add("");

        assertEquals("Should get 0 for empty string input", expected, actual);
    }

    @Test
    public void calculatorOneInputTest() throws NegativeNumbersException {
        Calculator calc = new Calculator();

        int expected = 4;
        int actual = calc.add("4");

        assertEquals("Should get 4 with one input", expected, actual);
    }

    @Test
    public void calculatorTwoInputsTest() throws NegativeNumbersException {
        Calculator calc = new Calculator();

        int expected = 8;
        int actual = calc.add("4,4");

        assertEquals("Should get 8 with two inputs", expected, actual);
    }

    @Test
    public void calculatorManyInputsTest() throws NegativeNumbersException {
        Calculator calc = new Calculator();

        int expected = 24;
        int actual = calc.add("4,4,4,4,4,4");

        assertEquals("Should get 24 with many inputs", expected, actual);
    }

    @Test
    public void calculatorManyInputsMixedDelimiterTest() throws NegativeNumbersException {
        Calculator calc = new Calculator();

        int expected = 24;
        int actual = calc.add("4,4\n4,4,4\n4");

        assertEquals("Should get 24 with mixed delimiters", expected, actual);
    }

    @Test
    public void calculatorManyInputsCustomDelimiterTest() throws NegativeNumbersException {
        Calculator calc = new Calculator();

        int expected = 24;
        int actual = calc.add("//:\n4,4\n4:4,4\n4");

        assertEquals("Should get 24 with custom delimiters", expected, actual);
    }

    @Test
    public void calculatorNegativeInputsTest() {
        Calculator calc = new Calculator();

        String expected = "negatives not allowed: -4";

        try {
            int sum = calc.add("//:\n4,-4\n4:4,4\n4");
            fail("Expected exception was not thrown");
        } catch (NegativeNumbersException e){
            assertEquals("Should get exception with negative number listed", expected, e.getMessage());
        }
    }

    @Test
    public void calculatorMultipleNegativeInputsTest() {
        Calculator calc = new Calculator();

        String expected = "negatives not allowed: -4, -1, -7";

        try {
            int sum = calc.add("//:\n4,-4\n4:4,4\n4,-1,-7");
            fail("Expected exception was not thrown");
        } catch (NegativeNumbersException e){
            assertEquals("Should get exception with negative numbers listed", expected, e.getMessage());
        }
    }
}
