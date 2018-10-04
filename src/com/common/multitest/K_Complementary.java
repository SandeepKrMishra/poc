package com.test.rakuten;

/**
 * Created by sandeepmishra on 16/08/18.
 */

import java.util.HashMap;

public class K_Complementary {

    public static void main(String[] str) {

        int K = 6;
        int[] A = {1, 8, -3, 0, 1, 3, -2, 4, 5};

        System.out.println("HKHR: "+ printpairs(K, A));

    }


    static int printpairs(int K, int[] A)
    {
        int numberOfPairs = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int i=0; i<A.length; i++){
            int remainingValue = K-A[i];
            hashmap.put(K/2, 1);

            if (remainingValue>=0 && hashmap.containsKey(remainingValue)){

                int mulVal = hashmap.get(remainingValue);
                if(remainingValue == K/2) {
                    numberOfPairs = numberOfPairs + mulVal;
                } else {
                    numberOfPairs = numberOfPairs + mulVal*2;
                }
            }
            if(hashmap.containsKey(A[i])) {
                int value = hashmap.get(A[i]);
                hashmap.put(A[i], value+1);
            } else {
                hashmap.put(A[i], 1);
            }
        }
        return numberOfPairs;
    }


}
