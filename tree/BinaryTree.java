package com.algorithm.tree;

import com.algorithm.LinearTable.queueClass.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    //成员变量
//    记录根结点
    private Node root;
    //    记录树中元素的个数
    private int N;
//    结点类
    private class Node{
//        储存键
    public Key key;
//    储存值
    private Value value;
//    记录左子结点
    public Node left;
//    记录右子结点
    public Node right;

    public Node(Key key, Value value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}


//    获取树中元素的个数
    public int size(){
        return N;
    }
//    向树中插入一个键值对
    public void put(Key key,Value value){

       root = put(root,key ,value );

    }
//    向指定的树添加key-value，并且返回添加元素后的新的树
    public Node put(Node x,Key key,Value value){
        if (x == null){
            N++;
            return new Node(key,value ,null ,null );
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right,key ,value );
        } else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left, key, value);
        }else {
            //如果key等于x结点的键，则替换x结点的值为value即可
            x.value = value;
        }
        return x;
    }
//    查询树中指定key对应的value
    public Value get(Key key){
      return get(root,key);
    }
    public Value get(Node x,Key key){
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right,key );
        }else if (cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left,key );
        }else {
            //如果key等于x结点的键，就找到了键为key的结点，只需要返回x结点的值即可
            return x.value;
        }
    }

//    删除树中key对应的value
    public void delete(Key key){
        delete(root,key);
    }
    public Node delete(Node x,Key key){
        if (x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            x.right = delete(x.right,key );
        }else if(cmp <0){
            x.left = delete(x.left,key );
        }else {
            N--;
//            删除结点处考虑没有右子结点
            if(x.right == null){
                return x.left;
            }
//            删除结点考虑没有左子结点
            if (x.left == null){
                return x.right;
            }
//            如果都存在
//            找到右子树的最小值或者左子树的最大值，这里使用右子树最大值
            Node minRightNode= x.right;
            while (minRightNode.left!=null){
                minRightNode = minRightNode.left;
            }
//            删除右子树的最小结点
            Node n = x.right;
            while (n.left !=null){
                if (n.left.left == null){
                    n.left = null;
                }else {
                    n =n.left;
                }
            }
//            最后，让x结点的左子树变成minRightNode的左子树
            minRightNode.left = x.left;
//             最后，让x结点的右子树变成minRightNode的右子树
            minRightNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minRightNode;


        }
        return x;
    }


//    查寻二叉树最小值
    public Key min(){
        return min(root).key;
    }
//    找最左边的
    public Node min(Node x){
        if (x.left!=null){
            return min(x.left);
        }else {
            return x;
        }
    }
//    寻找二叉树的最大值
    public Key max(){
        return max(root).key;
    }
//    找最右边的
    public Node max(Node x){
        if (x.right != null){
            return min(x.right);
        }else {
            return x;
        }
    }

//    二叉树遍历
//    1.前序遍历
// 使用前序遍历，获取整个树中的所有键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    //使用前序遍历，把指定树x中的所有键放入到keys队列中
    public void preErgodic(Node x,Queue<Key> queue){
        if (x == null){
            return;
        }
//        将当前结点放入到队列中去
        queue.enqueue(x.key);
        //2.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left!=null){
            preErgodic(x.left, queue);
        }
        //3.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null){
            preErgodic(x.right,queue );
        }
    }

//    中序遍历   比较重要，因为是有序的
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }
    public void midErgodic(Node x,Queue<Key> queue){
        if (x == null){
            return;
        }
        if (x.left != null){
            midErgodic(x.left,queue );
        }
        queue.enqueue(x.key);
        if (x.right != null){
            midErgodic(x.right,queue );
        }

    }

//    后序遍历
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys );
        return keys;
    }
    public void  afterErgodic(Node x,Queue<Key> queue){
        if (x == null){
            return;
        }
        if (x.left != null){
           afterErgodic(x.left,queue );
        }
        if (x.right != null){
            afterErgodic(x.right, queue);
        }
        queue.enqueue(x.key);
    }

//层序遍历
    public Queue<Key> layerErgodic(){

//        定义两个队列，一个是结点队列一个是key队列
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
//        结点类先压入一个根
        nodes.enqueue(root);
//        当结点队列nodes不为空时，循环继续
        while (!nodes.isEmpty()){
//            每次循环弹出一个node，压入一个key
          Node x =  nodes.dequeue();
          keys.enqueue(x.key);
//          判断该子结点的左右结点是否存在，要是存在就压入nodes队列
            if (x.left != null){
                nodes.enqueue(x.left);
            }
            if (x.right != null){
                nodes.enqueue(x.right);
            }
        }
        return keys;
    }

    //    树的最大深度问题
    public int maxDepth(){

        return maxDepth(root);
    }
    public int i =0;
    public int maxDepth(Node x){
//        思想把树分为左右两部分，先计算出左边最深，再计算出右边最深最深，比较后加一
        if (x == null){
            return 0;
        }
        int maxL = 0;
        int maxR = 0;
        int max = 0;
       i++;
        if (x.left!=null){
            maxL = maxDepth(x.left);
        }
        if (x.right!=null){
            maxR = maxDepth(x.right);
        }
        max = maxL > maxR ? maxL+1 :maxR +1;
        return max;

    }




}


