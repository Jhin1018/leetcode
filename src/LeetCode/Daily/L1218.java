package LeetCode.Daily;

import java.util.HashMap;
import java.util.Map;

public class L1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        Map<Integer,Integer> map = new HashMap<>();
         for(int i:arr){
             map.put(i,map.getOrDefault(i-difference,0)+1);
             res = Math.max(map.get(i),res);
         }
         return res;
    }


}
