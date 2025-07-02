package Recursion.Recursion_Basics;

import java.util.Arrays;

public class Reverse_An_Array {
    public static void main(String[] arga){
        int[] n = {1,2,3,4,5};
        reverseAnArray(n, 0, n.length-1);
        System.out.println(Arrays.toString(n));
    }

    public static void reverseAnArray(int [] n, int start, int end){
        if(start >=end) return;       // start >= end can handle even lengthed arrays unlike start==end (Tip- always use >= in two pointer recursions).
        int temp = n[start];
        n[start] = n[end];
        n[end] = temp;
        reverseAnArray(n,start+1, end-1);

    }
}

// TC: O(n)
//SC: O(n)