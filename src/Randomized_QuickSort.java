import java.util.Random;

public class Randomized_QuickSort {    //快速排序的随机化版本
    public void RandomizedQuickSort(int []A,int p,int r)
    {
        int q;
        if(p<r)
        {
            q=RandomizedPartition(A,p,r);
            RandomizedQuickSort(A,p,q-1);
            RandomizedQuickSort(A,q+1,r);
        }
    }

    private int RandomizedPartition(int [] A, int p, int r)
    {
        Random ran=new Random();
        int i=ran.nextInt(r);
//        int i= (int) Math.random();
        exchange(A,i,r);
        return Partition(A,p,r);
    }

    private int Partition(int []A,int p, int r)
    {
        int x=A[r];
        int i=p-1;
        for(int j=p;j<r;j++)
        {
            if(A[j]<=x)
            {
                i++;
                exchange(A,i,j);
            }
        }
        exchange(A,i+1,r);
        return i+1;
    }

    private void exchange(int []A,int i,int j)
    {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
