package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*

---------------------------------
Input parameters: (new String[] {"break3ing news5:"," 1A 1circle is round!",})
Result: (cBreaking News: A Circle Is Round!)
Expected: (Breaking News: A Circle Is Round!)
---------------------------------
Input parameters: (new String[] {"2Here2"," is"," our"," string",})
Result: (cHere Is Our String)
Expected: (Here Is Our String)
---------------------------------
Input parameters: (new String[] {"123","eat;sleep;repeat","321",})
Result: (cEat;Sleep;Repeat)
Expected: (Eat;Sleep;Repeat)
---------------------------------
Input parameters: (new String[] {"","Fresh fried fish - fish fresh fried",})
Result: (cFresh Fried Fish - Fish Fresh Fried)
Expected: (Fresh Fried Fish - Fish Fresh Fried)

 */
public class TestTakerTest {

    @Test
    void test1(){
        String ans = TestTaker.output(new String[] {"break3ing news5:"," 1A 1circle is round!",});
        Assertions.assertEquals("Breaking News: A Circle Is Round!", ans );
    }
}
