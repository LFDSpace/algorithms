package com.algorithm.LinearTable.stackClass;

import org.junit.Test;

public class TestClass {
    @Test
    public void testStack(){
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
//        System.out.println( stack.pop());
        for (Object str: stack){
            System.out.println(str);
        }
    }
}
