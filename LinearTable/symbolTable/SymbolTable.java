package com.algorithm.LinearTable.symbolTable;



//符号表
public class SymbolTable<Key,Value> {
//结点类
    private class Node{
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
    private int N ;

    public SymbolTable() {
        this.head = new Node(null,null ,null );
        this.N = 0;
    }

//    获取符号表中键值对的个数
    public int size(){
        return N;
    }
//    往符号表中插入键值对
    public void put(Key key,Value value){
//        先判断key值是否重复，要为重复则覆盖
      Node node = head;
      while (node.next!=null){
          node = node.next;
          if (node.key.equals(key)){
              node.value = value;
              return;//结束循环
          }

      }
      Node oldFirst = head.next;
      Node newFirst = new Node(key, value,oldFirst);
      head.next = newFirst;
//      数量加一
        N++;
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
