package com.algorithm.tree;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
//    结点类
    private class Node {
    //        结点类成员变量，有key，value，左子节点left，右子结点right，还有颜色color
    public Key key;
    public Value value;
    public Node left;
    public Node right;
    public boolean color;

    public Node(Key key, Value value, Node left, Node right, boolean color) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.color = color;
    }
}

//    红黑树类的成员变量  有根结点，记录树中元素的个数，
// 红色的父连接指向当前连接的标志，黑色的父连接指向当前连接的标志
    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

//    判断当前结点的父节点指向当前结点的链接是否为红色
    private boolean isRed(Node x){
        if (x == null){
            return false;
        }
        return x.color;
    }

//    获取树中的元素的个数
    public int size(){
        return N;
    }

//    左旋操作
    private Node rotateLeft(Node h){
//        先找到当前结点H的右子结点X
        Node H_R_X_Node = h.right;
//        再记录X结点的左结点
        Node X_L_Node = H_R_X_Node.left;
//        此时X结点的左节点，变为当前节点H的右子结点
        h.right = X_L_Node;
//        当前结点H变为X结点的左子节点
        H_R_X_Node.left = h ;
//       颜色  此时X的父指向连接颜色变为H的，H的变为红色
        H_R_X_Node.color = h.color;
        h.color = RED;
//        返回  因为最后父指向连接变为了X的，所以返回X
        return H_R_X_Node;
    }

//    右旋操作
    private Node rotateRight(Node h){
//        先找到当前结点H的左结点X
        Node H_L_X_Node = h.left;
//        再找到X结点的右子结点
        Node X_R_Node = H_L_X_Node.right;
//        X结点的左子结点变为当前结点左子结点
        h.left = X_R_Node;
//        当前结点H变为 X结点的左子结点
        H_L_X_Node.left = h;
//        颜色 X结点的父指向连接的颜色，为当前结点H的颜色，然后H结点的颜色改为RED
        H_L_X_Node.color = h.color;
        h.color = RED;
//        返回 X结点,因为最后父指向连接指向了X结点
        return H_L_X_Node;
    }
//    颜色反转
    private void flipColor(Node h){
//        颜色反转只需要将当前结点的左右两个子结点的父指向连接改为黑色，当前结点H的的父指向连接改为红色
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }
//    插入数据操作
    public void put(Key key,Value value){
        root = put(root,key,value);
//        因为根结点的父指向连接必须是黑色，所以每次增加完结点，根结点的父指向连接都为黑色
        root.color = BLACK;
    }
//    插入操作的重载实现
    public Node put(Node h,Key key,Value value){
        if (h ==null){
//            如果为空就创建新的结点
            Node newNode = new Node(key,value ,null ,null ,RED );
            N++;
            return newNode;
        }
//        不为空，判断是往左边插入还是往右边插入
        int cmp = key.compareTo(h.key);
        if (cmp<0){
//            向左继续
            h.left = put(h.left,key ,value );
        }else if (cmp>0){
//            向右继续
            h.right = put(h.right,key ,value );
        }else {
//            键相同，值覆盖
            h.value = value;
        }

//        判断是否进行左转,当前结点的左连接为黑，右连接为红
        if (isRed(h.right)&&!isRed(h.left)){
          h =  rotateLeft(h);  //这里需要h接受反转的结果
        }
//        判断是否进行右转。当前结点的左节点为红色，左节点的左节点为红色
        if (isRed(h.left)&&isRed(h.left.left)){
           h = rotateRight(h);
        }
//        颜色反转 当前结点的左节点右节点均为红色
        if (isRed(h.left)&&isRed(h.right)){
            flipColor(h);
        }

        return h;
    }
//    查找操作 根据key找到Value
    public Value get(Key key){
        return get(root,key );
    }
//    查找操作的重载
    public Value get(Node h,Key key){
        if (h==null){
            return null;
        }
        int cmp = key.compareTo(h.key);
        if (cmp<0){
//            向左继续
          return   get(h.left,key);
        }else if (cmp>0){
//            向右继续
          return   get(h.right,key);
        }else {
            return h.value;
        }
    }

}


