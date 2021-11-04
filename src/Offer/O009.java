package Offer;

public class O009 {
    /*
    滑动窗口解法
    两个指针从左端出发，右指针不断向右，当区间内的积大于等于目标时让左指针向右移动缩小区间大小
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int product = 1;
        int res = 0;
        while(right < nums.length){
            product *= nums[right];
            while(product>=k && left<= right){
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10,5,2,6};
        O009 o = new O009();
        System.out.println(o.numSubarrayProductLessThanK(input,100));
    }
}
