import BinarySearchTree.BinarySearchTree;
import BinarySearchTree.Node;

import java.util.Random;

public class main{
    public static void main(String[] args)  {
//        Solution so=new Solution();
//        int[] A={7,1,5,3,6,4};
//        System.out.println(so.maxProfit(A));

//        Class aClass = Class.forName(args[0]);
//        Class.getDeclaredConstructor();
////        aClass.newInstance()
//         Object o = constructors[0].newInstance();
//        Heap_sort hs=new Heap_sort();
//        int []A=new int[]{9,4,18,13,5,21,12,6};
//        hs.HeapSort(A);
////        System.out.println(A);
//        for(int i:A)
//        {
//            System.out.println(i);
//        }
        //优先队列测试
//        Priority_Queue pq=new Priority_Queue();
//        int []A=new int[]{9,4,18,13,5,21,12,6};
//        pq.Build_Heap(A);
//        System.out.println("MAX=="+pq.Max_Heap_Maximum());
//        System.out.println("MAX=="+pq.Max_Extract_Max());
//        pq.Max_Heap_Insert(5555);
//        System.out.println("MAX=="+pq.Max_Heap_Maximum());

        //快排测试


//        int [] A=new int[1000];
//        Random random=new Random();
//
//        for(int i=0;i<A.length;i++)
//        {
//            A[i]=random.nextInt(50);
//        }
//        int []A=new int[]{2,8,7,1,3,5,6,4};
//        long start=System.currentTimeMillis();
////        QuickSort qs=new QuickSort();
////        qs.Quick_Sort(A,0,A.length-1);
//        Randomized_QuickSort rqs=new Randomized_QuickSort();
//        rqs.RandomizedQuickSort(A,0,A.length-1);
//        long end=System.currentTimeMillis();
//        System.out.println("Sort timing:"+(end-start));
//        for(int i:A)
//        {
//            System.out.println(i);
//        }

        int [] test=new int[]{9,2,7,8,11,355,479,684,192,456};
        Node root=new Node();
        BinarySearchTree bst=new BinarySearchTree();
        for (int i:test)
        {
            Node node=new Node(i);
            bst.Node_Insert(root,node);
        }
        bst.InOrderTraverse(root);
        bst.Delete(root,bst.IterativeTreeSearch(root,192));
        bst.InOrderTraverse(root);
    }
}