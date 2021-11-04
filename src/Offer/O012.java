package Offer;

import java.util.Arrays;
/*
    先算总和，再用前缀和
    时间复杂度：O(n) 遍历了两边数组
    空间复杂度：O(1)
 */
public class O012 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int preSum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] + 2 * preSum == total){
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}
