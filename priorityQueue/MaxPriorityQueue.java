package com.algorithm.priorityQueue;
//最大优先队列
public class MaxPriorityQueue<T extends Comparable<T>> {

//    成员变量
    private T[] imtes;
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.imtes = (T[]) new Comparable[capacity+1];
        N = 0;
    }

    //    判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return imtes[i].compareTo(imtes[j])<0;
    }
//    交换堆中i索引和j索引处的值
    private void exch(int i,int j){
        T temp = imtes[i];
        imtes[i] = imtes[j];
        imtes[j] = temp;
    }

    //   往队列中插入一个元素
    public void insert(T t){
            imtes[++N] = t;//数组加一
            swim(N);//使用上浮调整
    }

    //    删除队列中最大元素，并返回这个最大值
    public T delMax(){
//        删除最大，就是删除跟节点处的值，删除需要用最后面一个值来顶替，然后使用下沉调整
        T max = imtes[1];

        exch(1, N);

//        imtes[N] = null;
        N--;
        sink(1);
        return max;
    }


//   使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
//        这里是k大于1别再错了
        while (k>1){
            if (less(k/2,k)){
                exch(k/2,k );
            }else {
                k  = k/2;
            }
        }
    }
//    使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        while (2*k<=N){
            int currmax ;
            if (2*k+1<=N){
                if (less(k*2,k*2+1 )){
                    currmax = k*2+1;
                }else {
                    currmax = k*2;
                }
            }else {
                currmax = k*2;
            }
           if (! less(k, currmax)){
               break;
           }
            exch(k,currmax );
            k= currmax;
        }


    }
//    获取队列中元素的个数
    public int size(){
        return N;
    }

//    判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

}
