package com.sb.dg.prob;

import com.sb.dg.model.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
    @Test
    void testAddTwoNumbers() {
        Problem pb = new Problem();
        ListNode l1N1 = new ListNode(2);
        ListNode l1N2 = new ListNode(4);
        ListNode l1N3 = new ListNode(3);

        l1N1.next = l1N2;
        l1N2.next = l1N3;

        ListNode l2N1 = new ListNode(5);
        ListNode l2N2 = new ListNode(6);
        ListNode l2N3 = new ListNode(4);

        l2N1.next = l2N2;
        l2N2.next = l2N3;
        ListNode listNode = pb.addTwoNumbers(l1N1, l2N1);

        //Assertions.assertEquals(7, listNode.val );
        Assertions.assertEquals(0, listNode.next.val );
        Assertions.assertEquals(8, listNode.next.next.val );

    }


    @Test
    void lengthOfLongestSubstring() {
        Problem pb = new Problem();
        Assertions.assertEquals(3, pb.lengthOfLongestSubstring_On("abcabcbb"));
        Assertions.assertEquals(3, pb.lengthOfLongestSubstring_O2n("pwwkew"));
        Assertions.assertEquals(4, pb.lengthOfLongestSubstring_On3("asdfssrrt"));

    }
}