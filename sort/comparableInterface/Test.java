package com.algorithm.sort.comparableInterface;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge(17);

        Student student2  = new Student();
        student2.setName("李四");
        student2.setAge(19);
        Comparable max = getMax(student1,student2 );
        System.out.println(max);
    }

//    测试方法，获取两个元素的较大值
    public static Comparable getMax(Comparable c1,Comparable c2){
        int cmp = c1.compareTo(c2);
        if (cmp>=0){
            return c1;
        }else{
            return c2;
        }
    }

}
