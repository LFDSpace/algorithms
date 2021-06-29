package com.algorithm.heap;

public class Heap<T extends Comparable<T>> {
//    储存堆中的元素 使用数组
    private T[] item;
//    记录堆中元素的个数
    private int N;

//    初始化
    public Heap(int capacity) {
        this.item = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }
//    判断i处的值是否小于j处的值
    public boolean less(int i,int j){
        return item[i].compareTo(item[j])<0;
    }
//    交换i处和j处的值
    public void exchange(int i,int j){
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }
//    往堆中插入一个值
    public void insert(T t){
//        因为0被舍弃了
        item[++N] = t;
//        因为堆的乱序需要使用swim上浮排序,对此时的N处进行排序
        swim(N);

    }
    public void swim(int k){
//        与上一个结点相比看是否大于上一个，要是大于交换，不大于结束
//        循环条件s到达了根结点
        while (k>1){
            if (less(k/2,k )){
                exchange(k/2,k );
            }
            k = k/2;
        }

    }
//    删除堆中最大的值，并且返回这个值
    public T delMax(){
        T max = item[1];
//      交换
        exchange(1,N );
//        同时别忘了把现在N的值给删除掉
        item[N] = null;
//        个数减一
        N--;
//        调用下浮，对堆进行有序整理
        sink(1);

        return max;
    }
//
    public void sink(int k){
//        进行下浮，找到左右结点中较大一个交换，在此之前要先判断一下，是否有右子结点，如果没有就仅与左比较。
//        循环条件，到达叶子结点
        while (k*2<N){
//            先判断是否有右结点,
            if (k*2+1<N){
                if (less(k*2,2*k+1)){
                    exchange(k,2*k+1 );
//                    更改k,为下次循环做准备
                    k = 2*k+1;
                }else{
                    exchange(k,k*2 );
//                       更改k,为下次循环做准备
                    k = k*2;
                }
            }else {
                if (less(k,2*k )){
                    exchange(k,k*2 );
//                       更改k,为下次循环做准备
                    k = k*2;
                }
            }
        }

    }


}
