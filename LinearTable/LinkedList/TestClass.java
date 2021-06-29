package com.algorithm.LinearTable.LinkedList;

import org.junit.Test;

public class TestClass {

    @Test
    public void testSequenceList(){
        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<>(10);
//测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");
//测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
//测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        System.out.println(sl.get(0));
//测试清空
        sl.clear();
        System.out.println("清空后的线性表中的元素个数为:"+sl.length());
    }

    @Test
    public void testSequenceListErgodic(){
        SequenceList<String> squence = new SequenceList<>(5);
//测试遍历
        squence.insert(0, "姚明");
        squence.insert(1, "科比");
        squence.insert(2, "麦迪");
        squence.insert(3, "艾佛森");
        squence.insert(4, "卡特");
        for (String s : squence) {
            System.out.println(s);
        }
    }
    @Test
    public void testLinkList(){
        LinkList<String> list = new LinkList<>();
        list.insert(0,"张三");
        list.insert(1,"李四");
        list.insert(2,"王五");
        list.insert(3,"赵六");

//        System.out.println(list.length());
//        System.out.println("-------------------");
//        //测试get方法
//        System.out.println(list.get(2));
//        System.out.println("------------------------");
//        //测试remove方法
//        String remove = list.remove(1);
//        System.out.println(remove);
//        System.out.println(list.length());
        System.out.println("----------------");;
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------");;
        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testTowWayLinkList(){
        TowWayLinkList<String> list = new TowWayLinkList<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert(1,"鸠摩智");
        list.insert(3,"叶二娘");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
    @Test
    public void testTowWayLinkList2(){
        TowWayLinkList2<String> list = new TowWayLinkList2<>();
        list.insert("乔峰");
        list.insert("虚竹");
        list.insert("段誉");
        list.insert(1,"鸠摩智");
        list.insert(3,"叶二娘");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

}
