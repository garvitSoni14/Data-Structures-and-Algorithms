package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I
{

    public static void main(String [] args)
    {
        int [] arr1 = {1,4,2};
        int [] arr2 = {1,2,300,4,5,6};
        System.out.println(Arrays.toString(NGE(arr1,arr2)));
    }

    public static int[] NGE(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--)     //Reverse Traversal on Parent array
        {
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){stack.pop();}  //pop if stack.pop is smaller
            if(stack.isEmpty()){map.put(nums2[i],-1);}
            else{map.put(nums2[i],stack.peek());}
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static int[] PGE(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        java.util.Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums2.length;i++)
        {
            while(!stack.isEmpty() && stack.peek()<=nums2[i]){stack.pop();}
            if(stack.isEmpty()){map.put(nums2[i],-1);}
            else{map.put(nums2[i],stack.peek());}
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static int[] NSE(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--)  //Reverse Traversal on Parent array
        {
            while(!stack.isEmpty() && stack.peek()>=nums2[i]){stack.pop();}    //pop if stack.pop is bigger
            if(stack.isEmpty()){map.put(nums2[i],-1);}
            else{map.put(nums2[i],stack.peek());}
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static int[] PSE(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> map = new HashMap<>();
        java.util.Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums2.length;i++)
        {
            while(!stack.isEmpty() && stack.peek()>=nums2[i]){stack.pop();}
            if(stack.isEmpty()){map.put(nums2[i],-1);}
            else{map.put(nums2[i],stack.peek());}
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }



}

