package com.algorithm.LinearTable.queueClass;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator{
        private Node node = head;

        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public T next() {
             node = node.next;
            return node.item;
        }
    }

    //    节点类
    private class Node{
        private T item;
        private Node next;

    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }
}
//成员变量
    private Node head;
    private int N;
    private Node last;

    public Queue() {
      head = new Node(null,null );
      last = null;
      N = 0;
    }
//    判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }
//    返回队列中的个数
    public int size(){
        return N;
    }
//    向队列中插入元素t
    public void enqueue(T t){
//        第一个值要存入last中去
        if (last == null){
           last = new Node(t,null );
           head.next = last;
        }else {
            Node oldLast = last;
            last = new Node(t,null );
           oldLast.next = last;
        }
//        数量+1
        N++;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
//        此时要注意一点，要是队列为空，last要为null；
        if (isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

}
