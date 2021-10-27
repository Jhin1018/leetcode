package Offer;

public class O006 {
    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum< target){
                left++;
            }else if(sum>target){
                right --;
            }else{
                return new int[]{left,right};
            }
        }
        return new int[]{0};
    }
}
