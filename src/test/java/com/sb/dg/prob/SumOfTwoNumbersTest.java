package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sb.dg.prob.SumOfTwoNumbers.canTwoMoviesFillFlight;

class SumOfTwoNumbersTest {
    private int[] arr = {34, 6, 87, 90, 9, 65, 34, 12, 54, 23, 87, 3, 77, 34};

    @Test
    void testCanTwoMoviesFillFlight() {
        Assertions.assertTrue(canTwoMoviesFillFlight(arr, 80));
        Assertions.assertFalse(canTwoMoviesFillFlight(arr, 81));
        Assertions.assertTrue(canTwoMoviesFillFlight(arr, 68));
        Assertions.assertTrue(canTwoMoviesFillFlight(arr, 21));
        Assertions.assertTrue(canTwoMoviesFillFlight(arr, 100));
    }
}