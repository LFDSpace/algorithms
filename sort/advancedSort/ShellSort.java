package com.algorithm.sort.advancedSort;

public class ShellSort {
//    希尔排序
    public static  void sort(Comparable[] c)  {
//        1:先确定增量h的值
        int h=1;
        while (h<c.length/2){
            h = 2*h+1;
        }
//        2:当增量h小于1时，排序结束
       while (h>=1){
           for (int i=h;i<c.length;i++){
               for (int j=i;j>=h;j=j-h){
                   if (greater(c[j-1],c[j] )){
                       exchange(c, j-1,j );
                   }
               }
           }

           h=h * 1/2;
       }

    }
    //    比较
    private static Boolean greater(Comparable c1,Comparable c2){
        return c1.compareTo(c2)>0;
    }
    //    交换
    private static void exchange(Comparable[] c,int i,int j){
        Comparable temp = c[i];
        c[i]=c[j];
        c[j]=temp;
    }
}
