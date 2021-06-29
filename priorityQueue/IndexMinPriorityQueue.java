package com.algorithm.priorityQueue;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
//   成员变量
    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;

//    构造函数
    public IndexMinPriorityQueue(int capacaity) {
        this.items = (T[]) new Comparable[capacaity+1];
        this.pq = new int[capacaity+1];
        this.qp = new int[capacaity+1];
        this.N = 0;

//        默认情况下，队列中没有存储任何数据，让qp中的元素都为-1；
        for (int i =0;i<qp.length;i++){
            qp[i]= -1;
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

//  判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

//    交换堆中i索引和j索引处的值  items数组不变，变得是pq数组 和qp数组
    private void exchange(int i,int j){
//        pq数组发生变化
        int temp= pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
//        qp数组发生变化
        qp[pq[i]] = i;
        qp[pq[j]] = j;

    }

//    判断k对应的元素是否存在
    public boolean contains(int k){
//        qp中的元素不等于-1说明该元素不存在
        return qp[k]!=-1;
    }

//    最小元素关联的索引
    public int minIndex(){
        return pq[1];
    }

//    往队列中插入一个元素，并关联索引i
    public void insert(int i,T t){
//        首先判断该处是否已经被关联，如果已经被关联，则不让插入。
        if (contains(i)){
            throw new RuntimeException("该索引已经存在");
        }
//        数量加一
        N++;
//        把数据存放到items数组对应的i处
        items[i] = t;
//        把i记录pq中
        pq[N] = i;
//        通过qp来记录pq中的i
        qp[i] = N;
//        通过上浮完成调整
        swim(N);
    }

//    删除队列中最小的元素，并返回该元素关联的索引
    public int delMin(){
//        先找到items中最小元素的索引
        int minIndex = pq[1];
//        pa数组
        exchange(1,N );
//        需要先删除qp中索引pq[N]处的值
        qp[pq[N]] = -1;
//        再删除pq
        pq[N] = -1;
//        删除items中的最小值
        items[minIndex] = null;
        N--;
        sink(1);
        return minIndex;
    }

//    删除索引i关联的元素
    public void delete(int i){
        int temp = qp[i];
        exchange(i,N );
        qp[pq[N]] = -1;
        pq[N] = -1;
        items[i] = null;
        N--;
//        因为不知道大小，所以下沉和上浮都要做
        sink(temp);
        swim(temp);
    }

//    把与索引i关联的元素修改为t
    public void changeItem(int i ,T t){
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }

//    上浮算法
    private void swim(int k){
        while (k>1){
            if (less(k ,k/2)){
                exchange(k, k/2);
            }else {
                k = k/2;
            }
        }
    }

//    下沉算法
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
