//https://leetcode.com/problems/top-k-frequent-elements/
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] count = new List[nums.length + 1];

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int freqVal = entry.getValue();
            if (count[freqVal] == null) {
                count[freqVal] = new ArrayList<>();
            }
            count[freqVal].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0 && index < k; i--) {
            if (count[i] != null) {
                for (int num : count[i]) {
                    res[index++] = num;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
