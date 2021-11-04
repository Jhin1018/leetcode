package Offer;

import java.util.HashMap;
import java.util.Map;
/*
    前缀和 + 哈希表
    区间[i,j]的和等于pre[j]-pre[i]
    用哈希表记录前缀和的出现次数
    当pre[i] = pre[j] - k时 取出次数
    时间复杂度O(n)
    空间复杂度O(n)
 */
public class O010 {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int res =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//初始化
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                res += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
