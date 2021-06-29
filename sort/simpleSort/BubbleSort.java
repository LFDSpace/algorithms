package com.algorithm.sort.simpleSort;

public class BubbleSort {

    public static void sort(Comparable[] c){
        for (int i = c.length-1;i>0;i--){
            for (int j = 0;j<i;j++){
                if (greater(c[j],c[j+1] )){
                    exchange(c,j ,j+1 );
                }
            }
        }
    }

//    比较大小
    private static boolean greater(Comparable c1,Comparable c2){
        return c1.compareTo(c2)>0;
    }
//    交换位置
    private static void exchange(Comparable[] c1,int i,int j){
        Comparable temp = c1[i];
        c1[i]=c1[j];
        c1[j] = temp;
    }


}
