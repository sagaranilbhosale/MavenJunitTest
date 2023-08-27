package com.sb.dg.prob;


import com.sb.dg.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCodeTrees {
    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> levelOrderUsingQ(TreeNode root) {
        List<List<Integer>> resq = new ArrayList<>();
        if (root == null) {
            return resq;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            resq.add(new ArrayList<>());

            int levelLength = queue.size();

            for (int i = 0; i < levelLength; i++) {
                TreeNode item = queue.remove();
                resq.get(level).add(item.getVal());
                if (item.getLeft() != null)
                    queue.add(item.getLeft());
                if (item.getRight() != null)
                    queue.add(item.getRight());
            }
            level++;
        }

        return resq;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root != null) {
            preOrderTraversal(root, 0);
        }
        return res;
    }

    private static void preOrderTraversal(TreeNode root, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.getVal());

        if (root.getLeft() != null) {
            preOrderTraversal(root.getLeft(), level + 1);
        }
        if (root.getRight() != null) {
            preOrderTraversal(root.getRight(), level + 1);
        }
    }
}

