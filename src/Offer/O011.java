package Offer;

import java.util.HashMap;
import java.util.Map;

public class O011 {
    /*
    前缀和+哈希表，同第10题思路相同
     */
    public int findMaxLength(int[] nums) {
        int preSum = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);//初始值
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            preSum += nums[i]==0?1:-1;
            if(map.containsKey(preSum)){
                maxLength = Math.max(maxLength,i-map.get(preSum));
            }
            map.putIfAbsent(preSum,i);//储存最前面的位置
        }
        return maxLength == Integer.MIN_VALUE?0:maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new O011().findMaxLength(new int[]{1,1,1,1,1,1,1,1}));
    }
}
