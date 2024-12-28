//https://leetcode.com/problems/container-with-most-water/
import static java.lang.Math.min;

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while (l < r){
            int vol = min(height[l], height[r]) * (r-l);
            if(vol > max){
                max = vol;
            }
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
