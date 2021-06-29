package com.algorithm.LinearTable.symbolTable;

//有序符号表
public class OrderSymbolTable<Key extends  Comparable<Key>,Value> {
    //结点类
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //成员变量
    private Node head;
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //    获取符号表中键值对的个数
    public int size() {
        return N;
    }

    //    往符号表中插入键值对
    public void put(Key key, Value value) {
        //记录当前结点
        Node curr = head.next;
//记录上一个结点
        Node pre = head;
//1.如果key大于当前结点的key，则一直寻找下一个结点
        while(curr!=null && key.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }
//2.如果当前结点curr的key和将要插入的key一样，则替换
        if (curr!=null && curr.key.compareTo(key)==0){
            curr.value=value;
            return;
        }
//3.没有找到相同的key，把新结点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
    }
//    删除符号表中键为key的键值对
    public void delete(Key key){
        Node node = head;
        while (node.next!=null){
            if (node.next.key.equals(key)){
                node.next = node.next.next;
//              数量建议
                N--;
                return;
            }
            node = node.next;
        }


    }
//        获取符号表中key对应的值
    public Value get(Key key){
        Node node = head;
        while (node.next!=null){
            node = node.next;
            if (node.key.equals(key)){
                return node.value;
            }}
        return null;
    }




}
