package com.algorithm.LinearTable.LinkedList;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    private class Node{
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
//    记录头结点
    private Node head;
//   记录链表长度
    private int N;
//    构造类
    public LinkList(){
//        初始化头结点
        head = new Node(null,null);
        N=0;
    }

//    清空链表
    public void clear(){
        head.next = null;
        head.item = null;
        N=0;
    }
//    获取链表长度
    public int length(){
        return N;
    }
//    判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }
//    获取指定位置i处的元素
    public T get(int i){
       Node n = head.next;
       for (int index = 0;index <i;index ++){
           n = n.next;
       }
       return (T) n.item;

    }
//    向链表中添加元素t
    public void insert(T t){
//        找到最后一个节点
        Node n = head;
        while (n.next != null){
            n = n.next;
        }
        Node newNode = new Node(t,null );
        n.next= newNode;
//        链表长度加1
        N++;
    }
//    在指定位置i处，添加元素t
    public void insert(int i,T t){
        if (i<0 || i>N){
            throw new RuntimeException("位置不合法");
        }
//        先找到该前一个位置
        Node pre = head;
        for (int index = 0;index <=i-1 ;index++){
            pre = pre.next;
        }
//        位置i的节点
        Node curr = pre.next;
//        构造新的节点，让新节点指向位置i的节点
        Node newNode = new Node(t,curr );
        pre.next = newNode;
        N++;
    }
//    删除指定位置处i的元素，并返回被删除的元素
    public T remove(int i){
//        先找到之前的
        Node pre = head;
        for (int index = 0;index<= i-1;index++){
            pre = pre.next;
        }
//        位置i的节点
        Node curr = pre.next;
//        前一个节点指向后一个节点
        pre.next = curr.next;
         N--;
         return (T) curr.item;
    }
//    查找元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for (int index = 0;n.next!=null;index++){
            n = n.next;
            if (n.item.equals(t)){
                return index;
            }
        }
        return -1;
    }

    // 为了遍历实现
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n =head;
        }

        @Override
        public boolean hasNext() {
           return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return  n.item;
        }
    }
    //    链表反转 用来反转整个链表
    public void reverse(){
        if (isEmpty()){
//            空链表不需要反转
            return;
        }
        reverse(head.next);
    }
    //    反转指定节点的curr，并把反转后的节点返回
    public Node reverse(Node curr){
//        已经到了最后一个节点
        if (curr.next == null){
//            反转后，头结点应该指向原链表中的最后一个元素
            head.next = curr;
            return curr;
        }
//        递归反转curr的下一个节点，返回值就是链表反转后，当前节点的下一个节点
//        curr 当前遍历的节点  反转后当前节点上一个节点

//        当前节点的上一个节点
        Node pre =  reverse(curr.next);
        pre.next = curr;
//        当前节点的下一个节点为null
        curr.next = null;
//       返回当前节点
        return curr;
    }






}
