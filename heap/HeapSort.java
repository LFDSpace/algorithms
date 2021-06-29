package com.algorithm.heap;



public class HeapSort {


//  判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
//  交换heap堆中i索引和j索引处的值
    private static void exech(Comparable[] heap,int i,int j){
        Comparable temp = heap[i];
        heap[i]= heap[j];
        heap[j] = temp;
    }
//    根据原数组source，构造处堆heap
//    堆的构造过程最直观的想法就是，另外创建一个新的数组，然后左往右遍历原数组，每得到一个元素后，
// 添加到，新的数组中后，使用上浮，对堆进行调整，最后新的数组组成一个堆
//    我这里使用一个巧妙地方法，把数组拷贝到一个新的数组后，再从新数组长度的一半处往1进行扫描，
// （从右往左），然后对扫描的每一个元素左下沉调整即可
    private static void createHeap(Comparable[] source,Comparable[] heap){
//        先把原数组中元素拷贝到heap中，这样heap中就成了无序的堆
        System.arraycopy(source,0 ,heap,1 ,source.length ) ;
//        对堆中的元素做下沉操作（循环条件是从长度的一半开始，大于0）
        for (int i =heap.length/2;i>0;i++ ){
            sink(heap,i,heap.length-1);
        }

    }

    //在heap堆中，对target处的元素做下沉，范围是0~range
    private static void sink(Comparable[] heap, int target, int range){
//        循环条件是2*target<=range
        while (2*target<=range){
            int max;
//            判断是否有右子结点
            if (2*target+1<=target){
                if (less(heap, 2*target,2*target+1 )){
                    max = 2*target+1;
                }else {
                    max = 2*target;
                }
            }else {
                max = 2*target;
            }

            //        比较当前结点值和较大子结点的值
            if(!less(heap,target ,max )){
                break;
            }
            exech(heap,target ,max );
            target = max;//继续下一个循环

        }

    }

//    对source数组中的数据从小道大排序
//    只是需要做类似删除的操作就好。
    public static void sort(Comparable[] source){
//        够建一个比原数组多1的数组，表示堆
        Comparable [] heap = new Comparable[source.length+1];
        createHeap(source,heap );
//        定义一个变量，记录未排序的元素中最大的索引
        int N = heap.length-1;
//        通过循环，交换1索引处的元素和排序中元素中最大的索引处的元素
        while (N != 1){
            exech(heap,1 ,N );
            N--;
            sink(heap,1 ,N );
        }
        //把heap中的数据复制到原数组source中
        System.arraycopy(heap,1,source,0,source.length);


    }



}
