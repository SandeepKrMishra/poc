package test.utopia.lab;

/**
 * Created by sandeepmishra on 09/09/18.
 */
import java.io.*;
import java.util.*;
class MaxNumOfChocolates {
    // Program to find the maximum number of chocolates
    // to be distributed equally among k students
    static int maxNumOfChocolates(int arr[], int n, int k)
    {
        HashMap <Integer,Integer> um = new HashMap<Integer,Integer>();

        // 'sum[]' to store cumulative sum, where
        // sum[i] = sum(arr[0]+..arr[i])
        int[] sum=new int[n];
        int curr_rem;

        // To store sum of sub-array having maximum sum
        int maxSum = 0;

        // Building up 'sum[]'
        sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + arr[i];

        // Traversing 'sum[]'
        for (int i = 0; i < n; i++) {

            // Finding current remainder
            curr_rem = sum[i] % k;

            // If true then sum(0..i) is divisible
            // by k
            if (curr_rem == 0) {
                // update 'maxSum'
                if (maxSum < sum[i])
                    maxSum = sum[i];
            }

            // If value 'curr_rem' not present in 'um'
            // then store it in 'um' with index of its
            // first occurrence
            else if (!um.containsKey(curr_rem) )
                um.put(curr_rem , i);

            else
                // If true, then update 'max'
                if (maxSum < (sum[i] - sum[um.get(curr_rem)]))
                    maxSum = sum[i] - sum[um.get(curr_rem)];
        }

        // Required maximum number of chocolates to be
        // distributed equally among 'k' students
        return (maxSum / k);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 2, 7, 6, 1, 4, 5 };
        int n = arr.length;
        int k = 3;
        System.out.println("Maximum number of chocolates: "
                + maxNumOfChocolates(arr, n, k));
    }
}
