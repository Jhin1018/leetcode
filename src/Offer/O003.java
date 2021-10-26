package Offer;

import java.util.Arrays;

public class O003 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i =2;i<=n;i++){
            res[i] = i%2==0? res[i>>1]:res[i-1]+1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new O003().countBits(5)));
    }
}
