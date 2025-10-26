package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestAndSmallest {
    public static void main(String[] args){
        int[] arr = { 1,2,44,67,88,99,7,3};
        int k = 4;
        System.out.println(kthLargestElement(arr, k));
        System.out.println(kthSmallestElement(arr, k));

    }


    public static int kthSmallestElement(int [] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr){
            maxHeap.add(i);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static int kthLargestElement(int [] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i:arr){
            maxHeap.add(i);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
