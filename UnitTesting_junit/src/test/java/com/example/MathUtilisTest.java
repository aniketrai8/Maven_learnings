package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilsTest {
    @Test
    void testMultiply() {
        MathUtils math = new MathUtils();
        assertEquals(42, math.multiply(6, 7));
    }
}
