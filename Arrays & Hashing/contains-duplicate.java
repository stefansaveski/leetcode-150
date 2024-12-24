//https://leetcode.com/problems/contains-duplicate/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            boolean seen = set.contains(nums[i]);
            if (seen) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
