package Offer;

public class O002 {
    public String addBinary(String a, String b) {
        if(a.equals("0")) return b;
        if(b.equals("0")) return a;
        int lenA = a.length();
        int lenB = b.length();
        StringBuffer res = new StringBuffer();
        int carry = 0;
        int i = lenA-1;
        int j = lenB-1;
        while(i>=0||j>=0||carry!=0){
            //字符串 a 和 b 只要有一个没遍历完，那么就继续遍历；
            //如果字符串 a 和 b 都遍历完了，但是最后留下的进位 carry != 0，那么需要把进位也保留到结果中。

            int digitA = i>=0 ? a.charAt(i) - '0':0;
            int digitB = j>=0? b.charAt(j) - '0':0;
            int sum = digitA + digitB + carry;
            carry = sum >=2?1:0;
            sum = sum>=2? sum-2:sum;
            res.append(sum);
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new O002().addBinary("010","100"));
    }
}
