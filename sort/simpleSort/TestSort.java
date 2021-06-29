package com.algorithm.sort.simpleSort;

import org.junit.Test;

import java.util.Arrays;

public class TestSort {

    @Test
    public void testBubbleSort(){
        Integer[] c = {5,4,3,2,1,6};
        BubbleSort.sort(c);
        System.out.println( Arrays.toString(c));
    }

    @Test
    public void testSelectionSort(){
        Integer[] c = {5,4,3,2,1,6,7,0};
        SelectionSort.sort(c);
        System.out.println( Arrays.toString(c));
    }

    @Test
    public void testInsertionSort(){
        Integer[] c = {5,4,3,2,1,6,7,0};
        InsertionSort.sort(c);
        System.out.println( Arrays.toString(c));
    }



}
