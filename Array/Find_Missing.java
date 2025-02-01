package Array;

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
}
