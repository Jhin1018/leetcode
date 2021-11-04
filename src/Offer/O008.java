package Offer;

public class O008 {
    /*
    滑动窗口解法
    两个指针从左端出发，右指针不断向右，当区间内的和大于等于目标时让左指针向右移动缩小区间大小
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left =0;
        int right =0;
        int sum =0;
        while(right<nums.length){
            sum+= nums[right];
            while(sum >= target){
                res = Math.min(res,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,3,1,2,4,3};
        System.out.println(new O008().minSubArrayLen(7,input));
    }
}

