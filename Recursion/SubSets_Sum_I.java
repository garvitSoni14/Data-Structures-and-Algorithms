package Recursion;

import java.util.ArrayList;


public class SubSets_Sum_I {

    public static ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> sumsubset = new ArrayList<>();
        func(0, 0, arr, arr.length, sumsubset);
        return sumsubset;
    }

    public static void func(int index, int sum, int[] arr, int size, ArrayList<Integer> sumsubset) {
        if (index == size) {
            sumsubset.add(sum);
            return;
        }
        func(index + 1, sum+arr[index], arr, size, sumsubset);
        func(index + 1, sum,arr,size, sumsubset);
    }

    public static void main(String[] args)
    {
        int[] sample = {1,2,3};
        System.out.println(subsetSums(sample));
    }
}
