package CanDetect;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

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
        System.out.println("SKIPPED");
    }

    @Test
    public void incompleteAssert() {
        List mockedList = Mockito.mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        Mockito.verify(mockedList);
    }
}
