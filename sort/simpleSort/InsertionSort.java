package com.algorithm.sort.simpleSort;

public class InsertionSort {
//    插入排序
    public static void sort(Comparable[] c){
        for (int i=0;i<c.length;i++){
            for (int j=i;j>0;j--){
                if (greater(c[j-1],c[j] )){
                    exchange(c,j-1 ,j );
                }else{
                    break;
                }
            }
        }
    }

//    比较
    private static Boolean greater(Comparable c1,Comparable c2){
        return c1.compareTo(c2)>0;
    }
//    交换
    private static void exchange(Comparable[] c,int i,int j){
        Comparable temp = c[i];
        c[i] = c[j];
        c[j]=temp;
    }
}
