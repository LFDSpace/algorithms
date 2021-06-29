package com.algorithm.LinearTable.LinkedList;

import java.util.Iterator;

public class TowWayLinkList<T> implements Iterable<T> {

//首节点
    private Node head;
//    最后一个节点
    private Node last;
//    链表的长度
    private int N;


//    节点类
private class Node{
    public Node(T item,Node pre,Node next) {
        this.item = item;
        this.pre = pre;
        this.next = next;
    }
    public T  item;
    public Node pre;
    public Node next;


}
    // 构造类
    public TowWayLinkList() {
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }
//    清空链表
    public void clear(){
//        this.head.next=null;
//        this.head.pre=null;
//        this.head.item=null;
//        this.last=null;
//        this.N=0;
       last = null;
       head.next = last;
       head.pre = null;
       head.item = null;
       N = 0;
    }
//    获取链表长度
    public int length(){
        return N;
    }
//    判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //    获取第一个元素
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }
    //    获取最后一个元素
    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return last.item;
    }
//    插入元素t

    public void insert(T t){
//        判断是否为空链表
       if (isEmpty()){
           Node newNode= new Node(t,head ,null );
           last = newNode;
           head.next = last;
       }else {
           Node oldLast = last;
           Node newLast = new Node(t, oldLast, null);
           oldLast.next = newLast;
           last = newLast;
       }
//       无论哪种实现N+1
        N++;
    }
//    向指定位置i处插入元素t
    public void insert(int i,T t){
        Node pre = head;
//        先找到i前一位
        for (int index=0;index < i ;index++){
            pre = pre.next;
        }

//     当前节点
        Node current = pre.next;
//        构造新节点
        Node newNode = new Node(t, pre, current);
        pre.next = newNode;
        current.pre = newNode;

        N++;

    }
//    获取指定位置处i的元素
    public T get(int i){
        Node node = head;
        for (int index= 0;index<i;index++){
            node = node.next;
        }
        return node.next.item;
    }

//    找到元素第一次出现的位置
public int indexOf(T t){
    Node n= head;
    for (int i=0;n.next!=null;i++){
        n = n.next;
        if (n.next.equals(t)){
            return i;
        }
    }
    return -1;
}
//删除位置i处的元素并且返回该元素
    public T remove(int i){
        Node pre = head;
//        先找到i前一位
        for (int index=0;index <i ;index++){
            pre = pre.next;
        }
//        找到当前的
        Node current = pre.next;
        Node curr_next = current.next;
        pre.next = curr_next;
        curr_next.pre = pre;
        N--;
        return current.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{

        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }



}


