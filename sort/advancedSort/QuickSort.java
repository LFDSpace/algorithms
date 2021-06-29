package com.algorithm.sort.advancedSort;

public class QuickSort {
//    对数组内的元素进行排序
    public static void sort(Comparable[] a){
            int lo = 0;
            int hi = a.length-1;
            sort(a,lo , hi);
    }
//    对数组a中，从索引lo到索引hi之间的元素进行排序
    public static void sort(Comparable[] a,int lo,int hi){
//        安全性校验
        if (hi<lo){
            return ;
        }
//        分组
        int partition = partition(a, lo, hi);  //这个位置是排序后的
//        左排序
        sort(a,lo,partition-1);
//        右排序
        sort(a,partition+1,hi);
//   左排序，右排序-1.+1是因为中间那个值不再参与下次排序
    }
//    对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a,int lo,int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi+1;
        while (true){
//            先从右边进行比较
            while (less(key,a[--right])){
//                判断是否到最左边
                if (right==lo){
                    break;
                }
            }
//            从右边进行比较
            while (less(a[++left],key )){
//                判断是否到了最右边
                if (left==hi){
                    break;
                }
            }
            if (left>=right){
                break;
            }else {
//                如果没到重合，就大循环一次交换一次
                exchange(a, left,right );
            }
        }
//        最后交换一下第一位置，和最终停止位置，返回最后停止位置的坐标
        exchange(a, lo,right );
        return right;
    }
//   判断v是否小于w
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<=0;
    }
//    交换a数组中，索引i和索引j处的值
    private static void exchange(Comparable[] a,int i,int j){
            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    }
}
