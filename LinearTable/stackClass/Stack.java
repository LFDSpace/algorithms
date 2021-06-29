package com.algorithm.LinearTable.stackClass;

import java.util.Iterator;

//栈的实现  链表实现
public class Stack<T> implements Iterable {
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
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
//    成员变量
    private Node head;//记录首结点
    private int N;//记录栈个数
//    构造函数  (别忘可初始化）
    public Stack() {
        head = new Node(null,null);
        N=0;
    }

//判断栈是否为空，是返回true，否返回false
    public boolean isEmpty(){
        return N==0;
    }
//获取栈中元素的个数
    public int size(){
        return N;
    }
//    弹出栈顶元素
    public T pop(){
        if (head.next==null){
            return null;
        }
        Node popNode = head.next;
        head.next = head.next.next;
//        个数减一
        N--;
        return popNode.item;
    }
//    向栈中压入数据
    public void push(T t){
        Node oldFirst = head.next;
        Node newNode = new Node(t, oldFirst);
        head.next = newNode;
//        个数加一
        N++;
    }


}
