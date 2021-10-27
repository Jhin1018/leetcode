package Offer;

import com.sun.tools.javac.util.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class O004 {
    //哈希表统计出现次数
    //时间复杂度O（n）
    //空间复杂度O（n）
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key) == 1) return key;
        }
        return -1;
    }

    /*
    分别确定二进制整数每一位
    取出数组中所有数字二进制的同一位累加，对三取余就是那个只出现一次的数在这一位上的值
     */
    public int singleNumber2(int[] nums) {
        int res =0;
        for(int i=0;i<32;i++){
            int cnt = 0;
            for(int num:nums){
                cnt += num>>i & 1; //取出第i位
            }
            if(cnt % 3 !=0){//取余的结果只会0或1，不为0时，说明目标数的第i位是1
                res |= 1<<i;
            }
        }
        return res;
    }
}
