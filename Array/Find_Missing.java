// BRUTE FORCE: For each number between 1 to N we will run a for loop and another inner for loop to search for this element in the array. TC: O(n^2), SC: O(1)
// BETTER APPROACH: Create a new array to store the occurance of each element of arr, then search if any index of the new array is zero and return it, cur itis the element that didnt occured(mising),{remember, the new array should have size = arr.length+1 , this +1 is for consideration of index of the missing element}. TC: O(2n), SC:(n).
// OPTIMAL APPROACH 1: Store the sum of all the numbersfrom 1 to N in a variable = (N*(N+1))/2,sum up all the elements of array, variable -total of array = missing number. TC: O(n), SC: O(1)
// OPTIMAL APPROACH 2: create a XOR1 and store xor from 1 to N, create another XOR2 and store XOR of elements of arra. and Xor of XOR1 ^ XOR2 will be the answer.
package Array;

import java.util.HashMap;

public class Find_Missing
{
    public static void main(String[] args)
    {
        int arr[] = {0,1,2,3,4,5,6,7,8,9}; //size = 10, so n will be 10(0-10)
        System.out.println("Missing element is : "+findMissing(arr));

    }

    public static int findMissing(int arr[])
    {
        int XOR = 0;
        int XOR2 = 0;
        for(int i=1;i<=arr.length;i++)
        {
            XOR^=i;
        }
        for(int i=0;i<arr.length;i++)
        {
            XOR2 ^= arr[i];
        }
        return XOR^XOR2;
    }
    // TC: O(n)
    // SC: O(1)

    public static int BETTER_1(int [] arr)
    {
        int [] hash = new int[arr.length+1];   //length+1 because we know that one element from 1 to N is missing in the given array.
        for(int i: arr)
        {
            if(i>=1 && i<=arr.length)
            { hash[i] = 1; }
        }
        for(int i:hash){
            if(i == 0) return i;
        }
    return -1;
    }
}
