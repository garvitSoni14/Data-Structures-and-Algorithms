// 1752: Check if Array Is Sorted and Rotated

package Array;

public class IF_Sorted_Rotated {

    public static void main(String [] args) {
        int [] sample = {3,4,5,1,2};
        System.out.println(check(sample));
    }

    public static boolean check(int[] nums) {
        int flag = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]) flag++;
        }
        if(nums[nums.length-1] > nums[0]) flag++ ;
        return flag<=1;

    }

}
