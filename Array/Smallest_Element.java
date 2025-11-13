package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Smallest_Element
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Smallest element in the array is : " + smallestElement(arr));
    }
    public static int smallestElement(int arr[])
    {   int min = arr[0];
        for(int i=0; i< arr.length; i++)
        {
            if(min>arr[i])
            {
                min = arr[i];
            }
        }
        return min;
    }

    public static ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        int s = Integer.MAX_VALUE;
        int sm = Integer.MAX_VALUE;
        boolean isupdated = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<s){
                sm = s;
                s = arr[i];
                if (sm != Integer.MAX_VALUE) isupdated = true;

            }
            else if(arr[i]<sm && arr[i]>s){
                sm = arr[i];
                isupdated = true;
            }
        }
        if(isupdated){
            res.add(s);
            res.add(sm);}
        else res.add(-1);

        return res;

    }
}
