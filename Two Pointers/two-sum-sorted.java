//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l < r){
            if(numbers[l] + numbers[r] == target){
                int[] temp = {l+1, r+1};
                return temp;
            }
            if(numbers[l] + numbers[r] > target){
                r--;
            }
            else
                l++;
        }
        return null;
    }
}
