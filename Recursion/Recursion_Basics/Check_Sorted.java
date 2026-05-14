package Recursion.Recursion_Basics;

public class Check_Sorted {
    public static void main(String[] arga){
        int[] n = {1,2,3,7,5};
        System.out.println(checkSorted(n,0,1));
    }

    public static boolean checkSorted(int [] arr, int a, int b){
       if(b == arr.length) return true;
       if(arr[a]>arr[b]) return false;
       return checkSorted(arr, a+1, b+1);

    }
}

// TC: O(n)
//SC: O(n)