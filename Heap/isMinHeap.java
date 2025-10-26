package Heap;

public class isMinHeap {
    public static void main(String[] args){
        System.out.println(isMinHeap(new int[]{10, 20, 30, 40, 50, 60, 70}));
        System.out.println(isMinHeap(new int[]{10, 200, 15, 30, 40}));
    }

    public static boolean isMinHeap(int[] arr){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int left = i*2+1;
            int right = i*2+2;
            if(left<n && arr[left]<arr[i]) return false;
            if(right<n && arr[right]<arr[i]) return false;
        }
        return true;
    }
}