package Heap;

public class isMaxHeap {
    public static void main(String[] args){
        System.out.println(isMaxHeap(new int[]{50, 30, 40, 10, 5, 20, 30}));
        System.out.println(isMaxHeap(new int[]{10, 20, 15, 30, 40}));
    }

    public static boolean isMaxHeap(int[] arr){
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            int left = i*2+1;
            int right = i*2+2;
            if(left<n && arr[left]>arr[i]) return false;
            if(right<n && arr[right]>arr[i]) return false;
        }
        return true;
    }
}
