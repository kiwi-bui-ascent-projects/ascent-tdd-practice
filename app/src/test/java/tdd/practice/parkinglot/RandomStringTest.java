package tdd.practice.parkinglot;

import org.junit.Test;

// You should always run Optimize Imports before pushing your code.  Extra imports make things look messy
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RandomStringTest {
    // This is what I like to see!
    @Test
    public void randomStringGetTest() {
        assertNotNull("RandomString get should return random String", RandomString.get());
    }
}
