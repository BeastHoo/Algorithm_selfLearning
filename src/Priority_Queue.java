public class Priority_Queue {
    private int heapSize;
    private int []A;
    public void Build_Heap(int []Heap)
    {
        heapSize=Heap.length-1;
        A=new int[10000];
//        A= Arrays.copyOfRange(Heap,0,Heap.length);
        for(int i=0;i<Heap.length;i++)
        {
            A[i]=Heap[i];
        }
        for(int i=(heapSize-1)/2;i>=0;i--)
        {
            Max_Heapify(i);
        }
    }


    public int  Max_Extract_Max()
    {
        if(heapSize<1)
        {
            System.err.println("heapSize OVERFLOW!");
            return Integer.MIN_VALUE;
        }
        int max=A[0];
        A[0]=A[heapSize];
        heapSize-=1;
        Max_Heapify(0);
        return max;
    }

    public int Max_Heap_Maximum()
    {
        return A[0];
    }

    public void Max_Heap_Insert(int key)
    {
        heapSize+=1;
        A[heapSize]=Integer.MIN_VALUE;
        Max_Increase_Insert(heapSize,key);
    }

    private void Max_Increase_Insert(int i, int key)
    {
        if(key<A[i])
        {
            System.err.println("new Key is SMALLER than the current Key!");
            return ;
        }
        A[i]=key;
//        int parent=Parent(i);
        while(i>0 && A[i]>A[Parent(i)])
        {
            int temp=A[i];
            A[i]=A[Parent(i)];
            A[Parent(i)]=temp;
            i=Parent(i);
        }
    }
    private void Max_Heapify(int i)
    {
        int r=Right(i);
        int l=Left(i);
        int largest;
        if(l<heapSize && A[l]>A[i])
        {
            largest=l;
        }else largest=i;
        if(r<heapSize && A[largest]<A[r])
        {
            largest=r;
        }
        if(largest!=i)
        {
            int temp=A[largest];
            A[largest]=A[i];
            A[i]=temp;
            i=largest;
            Max_Heapify(i);
        }

    }

    private int Left(int i)
    {
        return 2*i+1;
    }
    private int Right(int i)
    {
        return 2*i+2;
    }
    private int Parent(int i)
    {
        if(i%2==0)
        {
            return i/2-1;
        }
        else
        {
            return (i+1)/2-1;
        }
    }
}
