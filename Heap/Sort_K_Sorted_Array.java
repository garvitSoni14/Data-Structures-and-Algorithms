package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sort_K_Sorted_Array {
    public static void main(String[] args){
        int [] arr = new int[]{6, 5, 3, 2, 8, 10, 9};
        int k=3;
        System.out.println(Arrays.toString(sortKSorted(arr, k)));
    }

    public static int[] sortKSorted(int arr[], int k){
        int index = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<=k && i< arr.length; i++){
            minHeap.add(arr[i]);
        }
        for(int i= k+1; i< arr.length; i++){
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while(!minHeap.isEmpty()){
            arr[index++] = minHeap.poll();
        }
        return arr;
    }
}
