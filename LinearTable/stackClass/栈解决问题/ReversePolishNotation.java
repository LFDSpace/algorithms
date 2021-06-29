package com.algorithm.LinearTable.stackClass.栈解决问题;

import com.algorithm.LinearTable.stackClass.Stack;

//逆波兰表达式（后缀表达式）
public class ReversePolishNotation {
    public static void main(String[] args) {
//中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为：" + result);
    }

    /**
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果  operands
     */
    public static int calculate(String[] notation) {
//        创造一个储存栈
        Stack<Integer> operands = new Stack<>();
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            Integer op1;
            Integer op2;
            Integer result;
            //判断该字符串是不是运算符，如果不是，把该该操作数压入operands栈中
            switch (curr) {
                case "+":
                    op1 = operands.pop();
                    op2 = operands.pop();
                    result = op1 + op2;
                    operands.push(result);
                    break;
                case "-":
                    op1 = operands.pop();
                    op2 = operands.pop();
                    result = op2 - op1;
                    operands.push(result);
                    break;
                case "*":
                    op1 = operands.pop();
                    op2 = operands.pop();
                    result = op2 * op1;
                    operands.push(result);
                    break;
                case "/":
                    op1 = operands.pop();
                    op2 = operands.pop();
                    result = op2 / op1;
                    operands.push(result);
                    break;
                default:
//                    如果不是运算法就压栈
                    operands.push(Integer.parseInt(curr));
                    break;
            }
        }
//        遍历结束，取出栈中的最终结果
        Integer result = operands.pop();
        return result;
    }
}
