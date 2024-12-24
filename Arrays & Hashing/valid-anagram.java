//https://leetcode.com/problems/valid-anagram/
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabetA = new int[128];
        int[] alphabetB = new int[128];
        if(s.length() != t.length())
            return false;
        for(int i=0; i<s.length(); i++){
            alphabetA[s.charAt(i)] += 1;
            alphabetB[t.charAt(i)] += 1;
        }
        for(int i=0; i<128; i++){
            if (alphabetA[i] != alphabetB[i])
                return false;
        }
        return true;
    }
}
