package hkhr.neural.network;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

/**
 * Created by sandeepmishra on 09/04/18.
 */
public class Test_Oracle {
    String str1 = "abaaaa";
    String str = "nitin";

    public static void main(String[] args) {
        // length of str.
        // check the ll for single elements to max size of string.
        // to avoide duplicate we can use hashmap/hash set.

        Test_Oracle to = new Test_Oracle();
        //System.out.println(to.isPalendrom("av"));
        //to.executeTask("abaaaa");
        List<String> ap = to.findPalindroms("abaaaa");
        for(String s : ap) {
            System.out.println("HKHR : "+s);
        }
    }

    private void executeTask(String str) {
        int length = str.length();
        Set<String> set = new HashSet<String>();

        for (int l = 1; l<=length+1; l++) {
            for (int i = 0; i <= length-l; i++) {
                String subStr = str.substring(i, i+l);

                if(isPalendrom(str)) {
                    set.add(subStr);
                }

                System.out.println("====>"+subStr);

            }
        }
    }

    private boolean isPalendrom(String str) {
        int subStrLrn = str.length();
        if(subStrLrn == 1) {
            return true;
        }
        char[] cArr = str.toCharArray();
        for(int j = 0; j < subStrLrn/2; j++) {
            if(cArr[j] != cArr[subStrLrn-j-1]) {
                return false;
            }
        }

        return true;
    }


    private List<String> findPalindroms(String str){

        List<String> allPalindroms = new LinkedList<String>();

        final char[] arr = str.toCharArray();
        StringBuilder palindrome = new StringBuilder();

        for( int i = 0; i < arr.length-1; i++ ){

            if( arr[i+1] == arr[i] ){

                palindrome.setLength(0);
                palindrome.append(arr[i]);

                for( int j = i+1; j < arr.length && arr[i] == arr[j]; j++ ){
                    palindrome.append(arr[j]);
                    allPalindroms.add( palindrome.toString() );
                }
            }
            else if( i > 0 && arr[i-1] == arr[i+1] ){

                int left = i-1;
                int right = i+1;

                palindrome.setLength(0);
                palindrome.append(arr[i]);

                while( left >= 0 && right < arr.length && arr[left] == arr[right] ){
                    palindrome.insert(0, arr[left]).append(arr[right]);
                    allPalindroms.add(palindrome.toString());
                    --left;
                    ++right;
                }
            }
        }

        return allPalindroms;
    }
}
