package com.sb.dg.prob;

public class MatrixSearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("rows: " + rows + " cols: " + cols + " Target: " + target);
        if (rows == 1 && cols == 1 && matrix[0][0] == target) {
            return true;
        }
        int left = 0;
        int right = rows - 1;


        while (left <= right && rows > 1) {
            int pivot = (left + right) / 2;
//            System.out.println("pivot: " + pivot + " m[][] : " + matrix[pivot][cols-1]);
            if (target == matrix[pivot][cols - 1]) {
                return true;
            } else if (left == right) {
                break;
            }
            if (target > matrix[pivot][cols - 1]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        System.out.println("row: " + left);

        int col = left;
        left = 0;
        right = cols - 1;

        while (left <= right && cols > 1) {
            int pivot = (left + right) / 2;
            System.out.println("pivot: " + pivot + " m[][] : " + matrix[col][pivot]);
            if (target == matrix[col][pivot]) {
                return true;
            } else if (left == right) {
                return false;
            }
            if (target > matrix[col][pivot]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        return false;
    }
}
