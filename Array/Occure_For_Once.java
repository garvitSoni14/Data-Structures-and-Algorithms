// BRUTE FORCE: For every element of the array we will perform a linear search to find if it has single occurence, and return the element. TC: O(n^2), SC: O(1)
// BETTER APPROACH: We can use a HashMap to store the frequencies of each element and then we can return the element with frequency = 1. TC:O(n), SC:(n).
// OPTIMAL APPROACH: We can store the Xor of all the elements into a XOR variable and return it.
package Array;

public class Occure_For_Once
{
    public static void main(String[] args)
    {
        int arr[] = {1,1,2,2,3,3,4,4,5,5,8,8,6,6,7,7,9};
        System.out.println("The Element that is occuring for once is : " + occurForOnce(arr));
    }

    public static int occurForOnce(int arr[])
    {
        int XOR = 0 ;
        for(int i =0; i<arr.length; i++)
        {
            XOR^= arr[i];
        }
        return XOR;
    }
// TC: O(n)
// SC: O(1)

    public static int BRUTEFORCE(int[] arr){

        for(int i=0; i<=arr.length-1; i++){
            int freq =0;
            for(int j = 0; j<=arr.length-1; j++){
                if(arr[j] == arr[i]){
                    freq++;
                }
            }
            if(freq==1) return arr[i];
        }
        return -1;
    }

}
