public class QuickSort {
    public void Quick_Sort(int []A, int p, int r)
    {
        int q=r;
        if(p<r) {
            q = Partition(A, p, r);
            Quick_Sort(A, p, q - 1);
            Quick_Sort(A, q + 1, r);
        }
    }

    private int Partition(int []A, int p, int r)
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

    private void exchange(int []A,int a,int b)
    {
        int temp;
        temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}
