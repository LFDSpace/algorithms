package com.algorithm.LinearTable.stackClass.栈解决问题;

import com.algorithm.LinearTable.stackClass.Stack;

//括号匹配问题
public class BracketsMatch {
    public static void main(String[] args) {
        String str = "(上海(长安))";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配："+match);
    }
//    判断str中的括号是否匹配
    public static boolean isMatch(String str){
        Stack<String> chars = new Stack<>();
        for (int i=0;i<str.length();i++){
           String currChar =  str.charAt(i)+"";
           if (currChar.equals("(")){
               chars.push("(");
           }else if (currChar.equals(")")){
             String t =  chars.pop();
//             如果此时为空，则说明没有对称的左括号，直接false；
             if (t==null){
                 return false;
             }
           }
        }
//        在循环结束后查看栈内有没有值
        if (chars.isEmpty()){
            return true;
        }
        return false;
    }




}
