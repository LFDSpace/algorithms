package com.algorithm.tree.折纸问题;

import com.algorithm.LinearTable.queueClass.Queue;

public class PagerFolding {

    public static void main(String[] args) {
//构建折痕树
        Node tree = createTree(3);
//遍历折痕树，并打印
        printTree(tree);
    }

//   使用中序遍历打印所有结点内容
    private static void printTree(Node tree){
        if (tree == null){
            return;
        }
        printTree(tree.left);
        System.out.print(tree.item+",");
        printTree(tree.right);

    }


//    构造深度为N的折痕树  利用队列和折痕关系。每个结点的左子节点是down，右子结点是up
    private static Node<String> createTree(int N){
        Node root = null;
//       开始折纸
        for (int i = 0; i < N; i++) {
            if (i == 0){
//                创造根结点
               root = new Node("down",null , null);
//
            }else {
                //            创建储存结点的队列，使用队列建立二叉树关系
                Queue<Node> queue = new Queue<>();
                queue.enqueue(root);
//            当队列不为空，开启while循环
                while (!queue.isEmpty()){
                    Node temp = queue.dequeue();
                    if (temp.left != null){
                        queue.enqueue(temp.left);
                    }
                    if (temp.right != null){
                        queue.enqueue(temp.right);
                    }
//               如果该结点的左右子结点都为空，则为当前结点创建一个为down的左子结点，一个为up的右子结点
                    if (temp.left==null && temp.right==null){
                        temp.left = new Node("down",null ,null );
                        temp.right = new Node("up",null , null);
                    }
                }

            }
            }

        return root;

    }




//    结点类
    private static class Node<T>{
        private T item;
        private Node left;
        private Node right;

    public Node(T item, Node left, Node right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }
}

}
