package Offer;

public class O001 {
    //倍增法求值
    /*
    主要思路：将除数不断倍增，直到下一次倍增后被除数小于除数，将被除数减去除数，直到被除数小于除数
    这个方法类似于二分查找，查找的序列是除数乘2^k
    时间复杂度O（log(a) * log(b))
    空间复杂度O（1）
     */
    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE && b==-1) return Integer.MAX_VALUE; //处理溢出情况
        int res = 0;
        int flag = (a>0)^(b>0)?-1:1;
        if(a>0) a=-a;
        if(b>0) b=-b;
        while(a<=b){
            int cnt = 1;
            int val = b;
            while(val >= Integer.MIN_VALUE >>1 && a <= val<<1){// val如果小于了MIN_VALUE的一半，就会发生溢出
                cnt +=cnt;
                val +=val;
            }
            a -=val;
            res +=cnt;
        }
        return (flag == 1) ? res:-res;
    }

    public static void main(String[] args) {
        System.out.println(new O001().divide(15,-3));
    }
}
