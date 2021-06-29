package com.algorithm.LinearTable.LinkedList;

import java.util.Iterator;

//顺序表代码
// 为了遍历，实现Iterable接口，重写iterator方法

public class SequenceList<T> implements Iterable<T> {
//    储存元素的数组
    private T[] eles;
//     记录当前顺序表中的元素个数
    private int N;

//    构造方法(初始化）
    public SequenceList(int capacity){
        eles = (T[]) new Object[capacity];
        N = 0;
    }
//    讲一个线性表置为空
    public void clear(){
        this.N = 0;
    }
//    判断当前线性表是否为空
    public boolean isEmpty(){
        return this.N==0;
    }
//    获取当前线性表的长度
    public int length(){
        return N;
    }
//    获取指定位置的元素
    public T get(int i){
      return eles[i];
    }
//    向线性表添加元素t
    public void insert(T t){
        eles[N++] = t;
    }
//    在i位置处插入元素t
    public void insert(int i,T t){
        //元素已经放满了数组，需要扩容
        if (N==eles.length){
            resize(eles.length*2);
        }
        for (int index = N;index>i;index--){
            eles[index] = eles[--index];
        }
        eles[i] = t;
        N++;
    }
//    删除指定位置处的元素，并返回改元素
    public T remove(int i){
//        记录返回值
        T result = eles[i];
        for (int index = i;index<N-1;index++){
            eles[index] = eles[index+1];
        }
        N--;
        //当元素已经不足数组大小的1/4,则重置数组的大小
        if (N>0 && N<eles.length/4){
            resize(eles.length/2);
        }
        return result;
    }
//    查找t元素第一出现的位置
    public int indexOf(T t){
        for (int i =0;i <N;i++){
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
//打印当前线性表的元素
public void showEles(){
    for (int i = 0; i < N; i++) {
        System.out.print(eles[i]+" ");
    }
    System.out.println();
}

    // 为了遍历，实现Iterable接口，重写iterator方法
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    //在SequenceList内部提供一个内部类SIterator,实现Iterator接口，重写hasNext方法和next方法
    private class SIterator implements Iterator{
        private int cur;
        public SIterator(){
            this.cur =0;
        }

        @Override
        public boolean hasNext() {
            return this.cur<N;
        }

        @Override
        public Object next() {
            return eles[cur++];
        }
    }

//
//改变容量
private void resize(int newSize){
//记录旧数组
    T[] temp = eles;
//创建新数组
    eles = (T[]) new Object[newSize];
//把旧数组中的元素拷贝到新数组
    for (int i = 0; i < N; i++) {
        eles[i] = temp[i];
    }
}

}
