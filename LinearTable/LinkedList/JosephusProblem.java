package com.algorithm.LinearTable.LinkedList;
//约瑟夫问题
public class JosephusProblem {

//    节点类
    private static class Node<T>{
        private T item;
        private Node next;

    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }
    }
    public static void main(String[] args) {
//        构造循环链表
        Node<Integer> first = null;
    //    记录前一个节点
        Node<Integer> pre = null;
        for (int i=1;i<=41;i++){
//            第一个节点
            if (i == 1){
                first = new Node(i,null);
                pre = first;
                continue;
            }
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            if (i==41){
//                循环结束，让最后个结点指向第一个结点。
                pre.next = first;
            }
        }
//        使用count记录报数
        int count = 0;
//        遍历链表，每循环一次，count++
        Node<Integer> node_curr = first;
        Node<Integer> node_before = null;
        while (node_curr!=node_curr.next){
            count++;
            if (count == 3){
//               如果等于3 删除当前节点
                node_before.next = node_curr.next;
                System.out.print(node_curr.item+" ");
//                count清零
                count =0;
                node_curr = node_curr.next;

            }else {
//                如果不等于3，节点继续
                node_before = node_curr;
                node_curr = node_curr.next;
            }
        }
//        打印最后保留的
        System.out.println(node_curr.item);

    }

}
