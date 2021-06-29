package com.algorithm.tree;

import com.algorithm.LinearTable.queueClass.Queue;
import org.junit.Test;

public class TestClass {
    @Test
    public void testBinaryTree(){
        BinaryTree<Integer, String> bt = new BinaryTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
        bt.delete(1);
        System.out.println(bt.size());

    }
//测试前序遍历
    @Test
    public void testPreErgodic(){
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.preErgodic();
        for (String key : queue) {
            System.out.println(key+"="+bt.get(key));
        }
    }
//测试中序遍历
    @Test
    public void testMidErgodic(){
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.midErgodic();
        for (String key : queue) {
            System.out.println(key+"="+bt.get(key));
        }
    }
//测试后序遍历
    @Test
    public void testAfterErgodic(){

        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.afterErgodic();
        for (String key : queue) {
            System.out.println(key+"="+bt.get(key));
        }

    }

//    测试层序遍历
    @Test
    public void testLayerErgodic(){
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        Queue<String> queue = bt.layerErgodic();
        for (String key : queue) {
            System.out.println(key+"="+bt.get(key));
        }
    }

// 测试树的最大深度
    @Test
    public void testMaxDepth(){
        BinaryTree<String, String> bt = new BinaryTree<>();
        bt.put("E", "5");
        bt.put("B", "2");
        bt.put("G", "7");
        bt.put("A", "1");
        bt.put("D", "4");
        bt.put("F", "6");
        bt.put("H", "8");
        bt.put("C", "3");
        int i = bt.maxDepth();
        System.out.println(i);
    }

//    测试红黑树
    @Test
    public void testRedBlackTree(){
        RedBlackTree<Integer, String> bt = new RedBlackTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());

    }

}
