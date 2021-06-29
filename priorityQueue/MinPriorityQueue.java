package com.algorithm.priorityQueue;
//最小优先队列
public class MinPriorityQueue<T extends Comparable<T>> {
//   成员变量
    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity +1];
        this.N = 0;
    }
//    获取队列中元素的个数
    public int size(){
        return N;
    }
//    判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }
//    判断索引i处的索引是否小于索引j处的元素
    public boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

//    交换堆中i索引和j索引处的值
    private void exchange(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
//    往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
//    删除堆中最小的元素，并返回这个最小元素 这里把堆的思想给倒过来，最小值在最上面，然后每个结点都要比他们的子结点要大
    public T delMin(){
        T currMin = items[1];
        exchange(1,N );
        items[N] = null;
        N--;
        sink(1);
       return currMin;
    }
//    使用上浮算法
    private void swim(int k){
        while (k>1){
            if (less(k ,k/2)){
                exchange(k, k/2);
            }else {
                k = k/2;
            }
        }

    }
//    使用下沉算法
    private void sink(int k){
        while (2*k<=N){
            int currmin;
            if (2*k+1<=N){
                if (less(2*k,2*k+1 )){
                    currmin = 2*k;
                }else {
                    currmin = 2*k+1;
                }
            }else {
                currmin = 2*k;
            }

            if (!less(currmin,k )){
                break;
            }
            exchange(currmin,k );
            k = currmin;
        }
    }

}
