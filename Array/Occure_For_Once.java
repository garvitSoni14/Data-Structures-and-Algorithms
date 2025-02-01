package Array;

public class Occure_For_Once
{
    public static void main(String[] args)
    {
        int arr[] = {1,1,2,2,3,3,4,4,5,5,8,6,6,7,7};
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

}
