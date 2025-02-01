package Array;

public class Maximum_Consecutive_Ones
{
   public static void main(String[] args)
   {
       int [] arr = {1,1,0,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1};
       System.out.println("Maximum consecutive ones in the array are : " + maxConsecutiveOnes(arr));
   }

   public static int maxConsecutiveOnes(int arr[])
   {
       int result=0,count=0;
       for(int i=0; i<arr.length;i++)
       {
           if(arr[i]==1)
           {
               count+=1;

               if(count>=result)
               {
                   result = count;
               }
           }
           else if(arr[i]==0)
           {
               count=0;
           }

       }
       return result;
   }
}
