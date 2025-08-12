// BRUTEFORCE: Three nested loops to get all subarrays....TC: O(n^3), SC: O(1).
// BETTER APPROACH: Two nested loops to get all subarrays. TC: O(n^2), SC: O(1).
// OPTIMAL APPROACH: Using hashmap and prefixXor technique. Keep a running prefix XOR, and for each element add to the count the number of times (prefixXor ^ k) has occurred so far, then record the new prefix XOR frequency.
package Array;

import java.util.HashMap;

public class Count_Subarrays_Given_XOR_K {

    public static void main(String []args ){
        int []a = {4, 2, 2, 6, 4};
        int k=6;
        System.out.println(XOR_K(a, k));
    }

    public static int XOR_K(int arr[], int k){
        int xor=0, count=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(xor, 1);
        for(int i=0; i<arr.length; i++){
           xor ^= arr[i];
           int x = xor^k;
           if(mp.containsKey(x)) count+=mp.get(x);
           if(mp.containsKey(xor)) mp.put(xor, mp.get(xor)+1);
           else mp.put(xor, 1);
            }
        return count;
        }
// TC: O(n)
// SC: O(n)

    public static int XOR_K_BRUTRFORCE(int [] arr,int k){
        int count=0;
        for(int i=0; i<arr.length; i++){
            int XOR=0;
            for(int j=i; j<arr.length; j++){
                XOR^=arr[j];
                if(XOR==k) count ++;
            }
        }
        return count;
    }
}
