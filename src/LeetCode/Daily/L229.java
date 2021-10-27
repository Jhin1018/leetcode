package LeetCode.Daily;

import java.util.*;

public class L229 {
    public List<Integer> majorityElement(int[] nums) {
        //用map统计出现次数然后遍历map
        //统计次数需要o（n），遍历map也是o（n）
        //空间复杂度是o（n）
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > len / 3) {
                res.add(key);
            }
        }
        return res;
    }

    public List<Integer> majorityElement2(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for(int num:nums){
            if(vote1>0 && num == element1){
                vote1++;
            }else if(vote2 >0 && num == element2){
                vote2++;
            }else if(vote1==0){
                vote1 = 1;
                element1 = num;
            }else if(vote2 ==0){
                vote2 =1;
                element2 = num;
            }else{
                vote1 --;
                vote2 --;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num : nums){
            if(num == element1) cnt1++;
            if(num == element2) cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if(cnt1> nums.length /3 && vote1>0) res.add(element1);
        if(cnt2 > nums.length/3 && vote2>0) res.add(element2);
        return res;
    }
}