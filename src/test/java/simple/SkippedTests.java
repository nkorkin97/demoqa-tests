package simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Simple")
public class SkippedTests {

    @Test
    @Disabled("Some reason")
    void test1() {
        Assertions.assertTrue(false);
    }
    @Test
    @Disabled("Some reason")
    void test2() {
        Assertions.assertTrue(false);
    }
}
