package tdd.practice.romantodecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToDecimalTest {
    @Test
    public void r2dOneTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 1;
        int actual = r2d.get("I");

        assertEquals("Should get 1 from I", expected, actual);
    }

    @Test
    public void r2dFiveTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 5;
        int actual = r2d.get("V");

        assertEquals("Should get 5 from V", expected, actual);
    }

    @Test
    public void r2dTenTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 10;
        int actual = r2d.get("X");

        assertEquals("Should get 10 from X", expected, actual);
    }

    @Test
    public void r2dFiftyTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 50;
        int actual = r2d.get("L");

        assertEquals("Should get 5 from L", expected, actual);
    }

    @Test
    public void r2dHundredTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 100;
        int actual = r2d.get("C");

        assertEquals("Should get 100 from C", expected, actual);
    }

    @Test
    public void r2dFiveHundredTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 500;
        int actual = r2d.get("D");

        assertEquals("Should get 500 from D", expected, actual);
    }

    @Test
    public void r2dThousandTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 1000;
        int actual = r2d.get("M");

        assertEquals("Should get 1000 from M", expected, actual);
    }

    @Test
    public void r2dMultipleTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 3;
        int actual = r2d.get("III");

        assertEquals("Should get 3 from III", expected, actual);
    }

    @Test
    public void r2dFourTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 4;
        int actual = r2d.get("IV");

        assertEquals("Should get 4 from IV", expected, actual);
    }

    @Test
    public void r2dTwoThousandSixTest() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 2006;
        int actual = r2d.get("MMVI");

        assertEquals("Should get 2006 from MMVI", expected, actual);
    }

    @Test
    public void r2dTwo1994Test() {
        RomanToDecimal r2d = new RomanToDecimal();

        int expected = 1944;
        int actual = r2d.get("MCMXLIV");

        assertEquals("Should get 1944 from MCMXLIV", expected, actual);
    }
}
