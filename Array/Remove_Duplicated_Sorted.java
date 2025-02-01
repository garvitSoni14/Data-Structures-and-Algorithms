package Array;

import java.util.Arrays;

public class Remove_Duplicated_Sorted
{
    public static void main(String[] args)
    {

        int arr[] = {};
        removeDuplicatedFromSorted(arr);
        System.out.println("Set is : "+ Arrays.toString(arr));

    }
    public static void removeDuplicatedFromSorted(int arr[])
    {   int j = 0;
        for(int i=1; i<arr.length; i++)
        {
            if (arr[i] != arr[j])
            {
                j++;
                arr[j] = arr[i];
            }
        }
        System.out.println(j+1);
    }

}
