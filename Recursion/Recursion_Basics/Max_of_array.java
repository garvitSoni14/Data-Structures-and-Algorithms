package Recursion.Recursion_Basics;

public class Max_of_array {
    public static void main(String[] arga){
        int[] n = {101,23,3,6,66,7};
        System.out.println(findMax(n, 0));
    }

   public static int findMax(int [] arr, int start){
        if(start>=arr.length-1)return arr[start];
        return Math.max(arr[start], findMax(arr, start+1));

   }

}


