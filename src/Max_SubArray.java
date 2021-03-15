

public class Max_SubArray {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [] diff=new int[n];
        int prePrice=prices[0];
        for(int i=1;i<n;i++)
        {
            diff[i]=prices[i]-prePrice;
            prePrice=prices[i];
        }
        int [] getVal=FindMaxmumSubArray(diff,1,n-1);
        return getVal[2];
    }

    private int[] FindMaxmumSubArray(int[] A, int low,int high)
    {
        // int [] ret=new int[3];
        int mid;
        if(high==low)
        {
            return new int[]{low,high,A[low]};
        }
        else  mid=(low+high)/2;
        int []left_ret=FindMaxmumSubArray(A,low,mid);
        int []right_ret=FindMaxmumSubArray(A,mid+1,high);
        int []cross_ret=FindMaxCrossingSubArray(A,low,high,mid);
        if(left_ret[2]>=right_ret[2] && left_ret[2]>=cross_ret[2])
        {
            return left_ret;
        }
        else if(right_ret[2]>=left_ret[2] && right_ret[2]>=cross_ret[2])
        {
            return right_ret;
        }
        else return cross_ret;

    }

    private int[] FindMaxCrossingSubArray(int[]A,int low,int high,int mid)
    {
        // return new int[];

        int left_sum;int left_max=0;
        int sum;
        left_sum=Integer.MIN_VALUE;
        sum=0;
        for(int i=mid;i>=0;i--)
        {
            sum+=A[i];
            if(sum>left_sum)
            {
                left_sum=sum;
                left_max=i;
            }
        }
        sum=0;
        int right_sum=0;
        int right_max=0;
        for(int i=mid+1;i<=high;i++)
        {
            sum+=A[i];
            if(sum>right_sum)
            {
                right_sum=sum;
                right_max=i;
            }
        }

        return new int[]{left_max,right_max,left_sum+right_sum};
    }
}
