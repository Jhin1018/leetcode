package LeetCode;

public class L53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i =1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
