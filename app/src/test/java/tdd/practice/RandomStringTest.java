package tdd.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RandomStringTest {
    @Test
    public void randomStringGetTest() {
        assertNotNull("RandomString get should return random String", RandomString.get());
    }
}
