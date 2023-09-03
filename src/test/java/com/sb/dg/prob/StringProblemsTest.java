package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringProblemsTest {

    @Test
    void convert() {
        Assertions.assertEquals("ABDC", StringProblems.convert("ABCD", 3));
        Assertions.assertEquals("PAHNAPLSIIGYIR", StringProblems.convert("PAYPALISHIRING", 3));
        Assertions.assertEquals("PINALSIGYAHRPI", StringProblems.convert("PAYPALISHIRING", 4));
        Assertions.assertEquals("PAYPALISHIRING", StringProblems.convert("PAYPALISHIRING", 1));
        Assertions.assertEquals("A", StringProblems.convert("A", 3));
    }
}