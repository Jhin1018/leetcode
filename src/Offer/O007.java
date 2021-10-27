package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O007 {
    /*
    同L015 三数之和，经典面试题了
    先排序，需要O（nlogn）
    然后从小到大，先固定第一个数，然后双指针法向后寻找答案
    时间复杂度O（n^2)
    本体重点在于如何去除重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;//如果第一个数已经比target=0要大，那么后面的数只会更大
            if(i>0 && nums[i] == nums[i-1]) continue;//第一个数重复的情况跳过
            int target = -nums[i];
            int left =i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left]+nums[right] < target){
                    left++;
                }else if(nums[left]+nums[right]>target){
                    right--;
                }else{
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);
                    left++;
                    right--;
                    //如果移动过程中碰到重复元素，则继续移动
                    while(left<right && nums[left] == nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        O007 o = new O007();
        List<List<Integer>> res = o.threeSum(input);
        for(List<Integer> l:res){
            System.out.println(l.toString());
        }
    }
}
