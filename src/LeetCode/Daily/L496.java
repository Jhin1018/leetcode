package LeetCode.Daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L496 {
    /*
    暴力搜索
    时间复杂度O（mn)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            int j = 0;
            while(j<nums2.length && nums1[i] != nums2[j]){
                j++;
            }
            int k = j+1;
            while(k< nums2.length && nums1[i] > nums2[k]){
                k++;
            }
            res[i] = k<nums2.length? nums2[k] :-1;
        }
        return res;
    }

    /*
        单调栈
        逆序遍历数组2，并维护一个从栈底到栈顶单调递减的栈
        对于每个被遍历的数nums2[i]，从栈顶把所有比它小的数出栈，留在栈顶的就是它右边第一个更大元素，如果一直出栈到栈为空，那就是没有更大的数
        时间复杂度O（m+n）两个数组各自遍历一遍
        空间复杂度O（m）栈最多储存m个值，map储存m个值
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            int digit = nums2[i];
            while(!stack.empty() && stack.peek()<digit) stack.pop();
            map.put(digit,stack.empty()?-1:stack.peek());
            stack.push(digit);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i< nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L496().nextGreaterElement2(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
