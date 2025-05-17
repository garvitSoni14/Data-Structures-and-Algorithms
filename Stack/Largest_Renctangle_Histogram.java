package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Largest_Renctangle_Histogram
{

    public static void main(String[] args)
    {
        int [] arr = {2,1,5,6,3};
        System.out.println(largest_rectangle(arr));

    }

    public static int largest_rectangle(int [] heights)
    {
        int n = heights.length;
        int [] prev = prev_smaller(heights);
        int [] next = next_smaller(heights);

        int area = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(next[i]==-1) next[i]=n;
            int breadth = next[i]-prev[i]-1;
            int newArea = heights[i]*breadth;
            area = Math.max(area,newArea);
        }
        return area;
    }


    public static int[] next_smaller(int[] nums)
    {
        int [] next = new int[nums.length];
        java.util.Stack<Integer> stack = new Stack<>();

        for(int i=nums.length-1;i>=0;i--)  //Reverse Traversal on Parent array
        {
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){stack.pop();}    //pop if stack.pop is bigger
            if(stack.isEmpty()){next[i]=-1;}
            else{next[i]=stack.peek();}
            stack.push(i);
        }
        return next;
    }

    public static int[] prev_smaller(int[] nums)
    {
        int [] prev = new int[nums.length];
        java.util.Stack<Integer> stack = new Stack<>();

        for(int i=0; i< nums.length; i++)  //Reverse Traversal on Parent array
        {
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){stack.pop();}    //pop if stack.pop is bigger
            if(stack.isEmpty()){prev[i]=-1;}
            else{prev[i]=stack.peek();}
            stack.push(i);
        }
        return prev;
    }
}
