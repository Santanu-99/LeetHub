//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N+1][sum+1];
        for(int[] a : dp){
            Arrays.fill(a ,-1);
        }
        int ans = check(arr,N,sum,dp);
        return ans==1;
    }
    
    static int check(int[] arr , int idx , int sum , int[][] dp){
        if(sum == 0){
            return dp[idx][sum] = 1;
        }
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        
        int myAns = 0; 
        for(int i=idx;i>0;i--){
            if(sum - arr[i-1] >=0 ){
                if(check(arr,i-1,sum-arr[i-1],dp)==1){
                    myAns = 1;
                    break;
                }
            }

        }
        return dp[idx][sum]=myAns;
    }
}