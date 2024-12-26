//https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];
        int temp = 1;
        for(int i=0; i<nums.length; i++){
            prefixArr[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i=nums.length-1; i>=0; i--){
            System.out.println(i);
            suffixArr[i] = temp;
            temp *= nums[i];
        }
        for(int x : prefixArr){
            System.out.print(x + " ");
        }
        System.out.println();
        for(int x : suffixArr)
            System.out.print(x + " ");
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[i] = prefixArr[i] * suffixArr[i];
        }
        return res;
    }
}
