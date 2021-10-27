package Offer;

public class O005 {
    public int maxProduct(String[] words) {
        //1、使用二进制的26位记录每个单词中26个字母的出现情况，1为出现
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch: words[i].toCharArray()) {
                flags[i] |= 1 << (ch - 'a');
            }
        }
        //2、两个单词如果有相同字母，则对应的整数与运算后相同字母对应的数位为1,结果不为0；没有相同字母则结果为0
        int result = 0;
        for(int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++) {
                if((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result,prod);
                }
            }
        }
        return result;
    }

}
