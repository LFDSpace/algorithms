package com.algorithm.sort.advancedSort;

import org.junit.Test;

import java.util.Arrays;

public class TestSort {
    @Test
    public void testShellSort(){
        Integer[] a = {9,1,2,5,7,4,8,6,3,5} ;
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
    @Test
    public void testMergeSort(){
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void testQuickSort(){
        Integer[] a = {9,1,2,5,7,4,8,6,3,5} ;
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
