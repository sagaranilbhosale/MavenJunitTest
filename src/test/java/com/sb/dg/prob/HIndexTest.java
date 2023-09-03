package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sb.dg.prob.HIndex.calculateHIndex;

class HIndexTest {

    @Test
    void testCalculateHIndex() {

        int[] cit = new int[]{3, 0, 6, 1, 5};

        Assertions.assertEquals(3, calculateHIndex(cit));
    }

    @Test
    void testCalculateHIndex1() {

        int[] cit = new int[]{4, 4, 0, 0};

        Assertions.assertEquals(2, calculateHIndex(cit));
    }
    @Test
    void testCalculateHIndex2() {

        int[] cit = new int[]{100};

        Assertions.assertEquals(1, calculateHIndex(cit));
    }
    @Test
    void testCalculateHIndex3() {

        int[] cit = new int[]{1,7,9,4};

        Assertions.assertEquals(3, calculateHIndex(cit));
    }
    @Test
    void testCalculateHIndex4() {

        int[] cit = new int[]{1,3,1};

        Assertions.assertEquals(1, calculateHIndex(cit));
    }
}