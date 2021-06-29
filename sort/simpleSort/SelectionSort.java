package com.algorithm.sort.simpleSort;

public class SelectionSort {
//     选择排序
    public static void sort(Comparable[] c){
        for (int i= 0;i<=c.length-2;i++){
            int minIndex = i;
            for (int j=i+1;j<c.length;j++){
                if (greater(c[i],c[j] )){
//                    交换最小值所在的索引最小值
                    minIndex = j;
                }
            }
            exchange(c, i,minIndex );
        }
    }

//    比较
    private static Boolean greater(Comparable c1,Comparable c2){
        return c1.compareTo(c2)>0;
    }
//    交换
    private static void exchange(Comparable[] c,int i,int j){
        Comparable temp = c[i];
        c[i]= c[j];
        c[j]=temp;
    }
}
