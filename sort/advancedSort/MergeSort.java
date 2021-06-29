package com.algorithm.sort.advancedSort;

import java.util.Arrays;

public class MergeSort {

    private static Comparable[] assist;
//    对数组内的元素进行排序
    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length-1;
        sort(a, lo, hi);
    }
    private static void  sort(Comparable[]a,int lo,int hi){
      if (hi<=lo){
          return;
      }
      int mid = lo + (hi-lo)/2;
//      分治
      sort(a,lo,mid);
      sort(a,mid+1,hi);
//      合并
      merge(a, lo, mid,hi );
    }

//合并算法
    private static void merge(Comparable[] a,int lo,int mid,int hi){
//        定义三个指针
        int i = lo;//作为 辅助数组 assist的下标。
        int p1 = lo;//作为左边数组的下标
        int p2 = mid+1;//作为右边数组的下标

        while(p1 <= mid && p2 <= hi){
            if (less(a[p1],a[p2] )){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }
//      等上一个while循环结束，退出的条件有：1，p1<=mid代表左边已经填充结束，若是p2<=hi 则代表右边已经填充结束
        while (p1<=mid){
            assist[i++] = a[p1++];
        }
        while (p2<=hi){
            assist[i++] = a[p2++];
        }
        System.out.println(Arrays.toString(assist));

//        把辅助数组中 assist中，从lo到hi的有序元素，copy到数组a中
        for (int index= lo;index<=hi;index++){
            a[index] =assist[index];
        }
    }



//    判断c1是否小于c2
    private static Boolean less(Comparable c1,Comparable c2){
        return c1.compareTo(c2)<=0;
    }

//    交换a数组中，索引i和索引j处的值
    private static void exchange(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

