//https://leetcode.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l < r){
            if(!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))){
                r--;
                continue;
            }

            System.out.println(Character.toLowerCase(s.charAt(l)) + " " + s.charAt(r));
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
