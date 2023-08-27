package com.sb.dg.prob;

import com.sb.dg.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.sb.dg.prob.LeetCodeTrees.levelOrder;
import static com.sb.dg.prob.LeetCodeTrees.levelOrderUsingQ;

class LeetCodeTreesTest {

    @Test
    void testLevelOrder() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        int[][] twoDimArray = {{3}, {9, 20}, {15, 7}};

        TreeNode root = TreeNode.buildTreeFromArray(arr);

        TreeNode.printTree(root, "-");

        List<List<Integer>> mat = levelOrder(root);

        mat.equals(array2DHelper(twoDimArray));
    }

    @Test
    void testLevelOrderUsingQ() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        int[][] twoDimArray = {{3}, {9, 20}, {15, 7}};

        TreeNode root = TreeNode.buildTreeFromArray(arr);

        TreeNode.printTree(root, "-");

        List<List<Integer>> mat = levelOrderUsingQ(root);

        mat.equals(array2DHelper(twoDimArray));
    }

    private List<List<Integer>> array2DHelper(int[][] twoDimArray) {
        return Arrays.stream(twoDimArray)
                .map(row -> Arrays.stream(row).boxed().toList())
                .toList();
    }


}