package com.sb.dg.prob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixSearchTest {

    @Test
    void testSearchMatrix(){
        Assertions.assertTrue(MatrixSearch.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
    }
    @Test
    void testSearchMatrix1(){
        Assertions.assertFalse(MatrixSearch.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}},13));
    }
    @Test
    void test1DMatrix(){
        Assertions.assertTrue(MatrixSearch.searchMatrix(new int[][] {{1,1}},1));
    } @Test
    void test1DMatrix1(){
        Assertions.assertTrue(MatrixSearch.searchMatrix(new int[][] {{1},{3}},3));
    }
    @Test
    void test1DMatrix2(){
        Assertions.assertTrue(MatrixSearch.searchMatrix(new int[][] {{1,2}},2));
    }

    @Test
    void searchMatrix() {
        Assertions.assertFalse(MatrixSearch.searchMatrix(new int[][] {{1}},2));
    }
}