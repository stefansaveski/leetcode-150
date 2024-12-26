//https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxStreak = 1;
        int streak = 1;
        if(nums.length == 0)
            return 0;
            
        for(int x : nums){
            System.out.print(x + " ");
        }
        //System.out.println();
        for(int i=0; i<nums.length-1; i++){
            //System.out.println(nums[i] + " " + nums[i+1]);
            if(nums[i] == nums[i+1])
                continue;
            if(nums[i+1] == nums[i]+1){
                //System.out.println("Accepted");
                streak++;
                if(streak > maxStreak){
                    maxStreak = streak;
                }
            }
            else {
                streak = 1;
            }
        }
        return maxStreak;
    }
}
