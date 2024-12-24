//https://leetcode.com/problems/group-anagrams/
class Solution {
    public boolean isAnagram(String a, String b){
        if (a.length() != b.length()) {
            return false;
        }
        char[] sArray = a.toCharArray();
        char[] tArray = b.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> used = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            List<String> tempList = new ArrayList<>();
            if(used.contains(strs[i]))
                continue;
            tempList.add(strs[i]);
            used.add(strs[i]);
            for(int j=0; j<strs.length; j++){
                if(isAnagram(strs[i], strs[j]) && i != j){
                    tempList.add(strs[j]);
                    used.add(strs[j]);
                }
            }
            if(!tempList.isEmpty())
                res.add(tempList);
        }
        return res;
    }
}
