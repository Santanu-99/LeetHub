//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    out.println(new Solution().findLongestConseqSubseq(a, n));
		    t--;
		}
		out.flush();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   // add your code here
	   HashMap<Integer,Boolean> hm = new HashMap<>();
	   for(int i=0;i<arr.length;i++){
	       hm.put(arr[i] , true);
	   }
	   
	   for(int i=0;i<arr.length;i++){
	       if(hm.containsKey(arr[i]-1)){
	            hm.put(arr[i] , false);
	       }
	   }
	   
	   int maxLength = 0;
	   for(int i=0;i<N;i++){
	        if(hm.get(arr[i]) == true){
	           int len = 1;
	           int temp = arr[i];
	           while(hm.containsKey(temp+1)){
	                len = len + 1;
	                temp = temp + 1;
	           }
	           maxLength = Math.max(len , maxLength);
	        }
	   }
	   
	   return maxLength;
	   
	   
	   
	}
}