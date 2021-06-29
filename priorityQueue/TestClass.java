package com.algorithm.priorityQueue;

import org.junit.Test;

public class TestClass {
    @Test
    public void testMaxPriorityQueue(){
        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
        for (String s : arr) {
            maxpq.insert(s);
        }
        System.out.println(maxpq.size());
        String del;
        while(!maxpq.isEmpty()){
            del = maxpq.delMax();
            System.out.print(del+",");
        }
    }
    @Test
    public void testMinPriorityQueue(){
        String[] arr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        MinPriorityQueue<String> minpq = new MinPriorityQueue<>(20);
        for (String s : arr) {
            minpq.insert(s);
        }
        System.out.println(minpq.size());
        String del;
        while(!minpq.isEmpty()){
            del = minpq.delMin();
            System.out.print(del+",");
        }

    }
}
