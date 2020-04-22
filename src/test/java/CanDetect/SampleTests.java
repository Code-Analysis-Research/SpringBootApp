package CanDetect;

import org.junit.Ignore;
import org.junit.Test;

public class SampleTests {
    // No Assertions
    @Test
    public void invalidName() throws Exception {
        SampleClass.addNumbers(1, 5);
        Thread.sleep(500); // Do not sleep in test
    }

    // Should not ignore tests
    @Ignore
    @Test
    public void ignoredTest() {

    }
}
