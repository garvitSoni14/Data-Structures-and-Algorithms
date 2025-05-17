package SlidingWindowAndTwoPointers;

public class Maximum_Point_From_Cards
{
    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,1};
        int j = 3;
        System.out.println(maxScore(array,j));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int maxSum=0, leftSum=0, rightSum=0, right = cardPoints.length -1;
        for(int i=0; i<k; i++)
        {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        for(int i=k-1; i>=0; i--)
        {
            leftSum -= cardPoints[i];
            rightSum+=cardPoints[right];
            right--;
            maxSum = Math.max(maxSum, (leftSum + rightSum));
        }
        return maxSum;}
}
