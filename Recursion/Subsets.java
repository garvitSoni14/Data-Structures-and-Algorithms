package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets
{
    public static List<List<Integer>> subset(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findsubset(0, nums, current, result);
        return result;
    }
    public static void findsubset(int index, int[] nums, List<Integer> current, List<List<Integer>> result)
    {
        result.add(new ArrayList<>(current));
        for(int i=index;i<nums.length;i++)
        {
            current.add(nums[i]);
            findsubset(i+1,nums, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String [] args)
    {
        int[] sample = {1,2,3};
        System.out.println(subset(sample));
    }

}
