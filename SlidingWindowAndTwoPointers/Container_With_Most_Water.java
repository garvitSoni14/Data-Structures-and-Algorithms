//BRUTE_FORCE: Generate all possible water volumes and return the maximum volume achieved. TC: O(n^2), SC: O(1).
//OPTIMAL_APPROACH: Use two pointers and shift the smaller height pointer to next to maximize the volume.
package SlidingWindowAndTwoPointers;

public class Container_With_Most_Water {

    public static void main (String [] args){
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxWaterVolume(height));
    }


        public static int maxWaterVolume(int[] height) {
            int answer = 0;
            int left=0, right=height.length-1;
            while(left<right){
                int width=right-left;
                int length = Math.min(height[right], height[left]);
                int volume = width*length;
                answer = Math.max(answer, volume);
                if(height[left] < height[right])left++;
                else right--;
            }
            return answer;

        }

        //TC: O(n)
        //SC: O(1)

    public static int maxWaterVolume_BRUTEFORCE(int [] height){
        int answer = 0;
        for(int i=0; i<height.length-1;i++){
            int leftBound = i;
            for(int j=i+1; j<height.length; j++){
                int tankWidth = j-i;
                int tankHeight = Math.min(height[i], height[j]);
                int waterVolume = tankHeight*tankWidth;
                answer = Math.max(answer, waterVolume);
            }
        }
        return answer;
    }
}
