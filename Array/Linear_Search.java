package Array;

public class Linear_Search
{
    public static void main(String[] args)
    {
        int arr[] = {11,45,23,56,89,76};
        int find = 45;
        System.out.print("Element "+find+" is found at : "+linearSearch(arr,find));
    }

    public static int linearSearch(int arr[], int k)
    {
        for(int i = 0;i<arr.length; i++)
        {
            if(arr[i] == k)
            {
                return i;
            }
        }
        return -1;
    }
}
