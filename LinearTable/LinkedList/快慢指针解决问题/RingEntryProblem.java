package com.algorithm.LinearTable.LinkedList.快慢指针解决问题;
// 有环链表入口问题
public class RingEntryProblem {
    public static void main(String[] args) throws Exception {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);
//完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
//产生环
        seven.next = third;
//查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);

    }
//    找到环链表的入口
    public static Node getEntrance(Node<String> first) {
//        定义三个指针变量 fast快指针 slow慢指针 temp临时指针
        Node<String> slow = first;
        Node<String> fast = first;
        Node<String> temp = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)){
                temp = first;
                continue;
            }
            if (temp != null){
                temp = temp.next;
                if (temp.equals(slow)){
                    return temp;
                }
            }
            System.out.println("ceshi");
        }
        return null;
    }


    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
