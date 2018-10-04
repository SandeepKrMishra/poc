package com.test.rakuten;

import java.util.HashMap;

/**
 * Created by sandeepmishra on 31/08/17.
 */
public class RecutenProb1 {

    public static void main(String[] args) {
        System.out.println("HKHR");

        int k = 6;
        int[] A = {1, 8, -3, 0, 1, 3, -2, 4, 5};

        System.out.print(solution(k, A));
    }

    public static int solution(int K, int[] A) {

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if ((A[i] + A[j] == K) && (i != j)) {
                    count = count + 1;
                }
            }
        }
        return count;
    }


    public static int solution1(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code in Java SE 8

        int leftPointPosition = Math.max(K, P);
        int rightPointPosition = Math.min(M, R);
        int bottomPointPosition = Math.max(L, Q);
        int topPointPosition = Math.min(N, S);

        // area of first rectangle
        int v1 = Math.abs(N - L);
        int d1 = Math.abs(M - K);
        int a1 = v1*d1;


        // area of second rectangle
        int v2 = Math.abs(S - Q);
        int d2 = Math.abs(R - P);
        int a2 = v2*d2;

        int a3 = 0;
        if (leftPointPosition < rightPointPosition && bottomPointPosition < topPointPosition) {
            int v3 = (rightPointPosition - leftPointPosition);
            int d3 = (topPointPosition - bottomPointPosition);
            a3 =  v3*d3;
        }

        int totalArea = a1+a2-a3;
        return totalArea;
    }
}
