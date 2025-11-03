package Array;


//https://youtu.be/qLjmipfCceo?si=LcpEySl9DMiwJ4QK

//TC: O(3n) = O(n)
//    SC: O(1)

public class FindMissingElement_PigeonHole {
    public static void main(String[] args){
        int [] sample = {7,8,9,11,12};
        System.out.println(firstMissingPositive(sample));
    }

    public static int firstMissingPositive(int[] nums) {
        int l = nums.length;
        for(int i=0; i<l; i++){
            if(nums[i]<=0 || nums[i]>=l+1) nums[i] = l+1;
        }

        for(int i=0; i<l; i++){
            int el = Math.abs(nums[i]);
            if(el == l+1) continue;
            int seat = el-1;
            if(nums[seat]>0) nums[seat] *= -1;
        }

        for(int i=0; i<l; i++){
            if(nums[i]>0) return i+1;
        }
        return l+1;
    }
}


