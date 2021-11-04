package JD;
/*
小游戏
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小W非常喜欢数学，而现在他很无聊，所以他想玩一种数字小游戏。这个数字小游戏规则如下：初始有一个数字a，该数字不包含0，同时具有一个数字之间的映射关系f，可以将x替换为f(x)，其中x为1-9的数字，现在可以选择a中一段连续的数位（也可以不选择），对其应用映射关系f，求能够获得的最大的数。



输入描述
第一行1个整数n，0<n<=10^5，表示该数的位数。

第二行一个字符串包含1-9的数字，表示初始的数字a。

第三行包含9个空格隔开的整数表示f(1)，f(2)，…，f(9)（0<f(i)<10）

输出描述
一行一个整数，表示最后能获得的最大的数。


样例输入
7
2211131
2 1 1 1 1 1 1 1 1
样例输出
2222231

提示
将第3位到第5位的111替换成222（即f(1)f(1)f(1)）



样例2：

输入：

3

999

1 1 1 1 1 1 1 1 1

输出：

999

提示：

不替换的情况下能获得的数最大
 */
import java.util.Scanner;

public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] f = new int[10];
        f[0] = 0;
        String str = sc.next();
        int i =0;
        for(char c:str.toCharArray()){
            input[i] = c -'0';
            i++;
        }
        for(int k=1;k<10;k++){
            f[k] = sc.nextInt();
        }
        boolean[] flag = new boolean[n+1];
        int[] res= new int[n+1];
        int k =0;
        for(k=1;k<=n;k++){
            res[k] = input[k-1];
            if(res[k] < f[input[k-1]]){
                flag[k] = true;
                res[k] = f[input[k-1]];
            }
            if(res[k] == f[input[k-1]] && flag[k-1]){
                flag[k] = true;
            }
            if((!flag[k]) && flag[k-1] ){
                break;
            }
        }
        for(;k<=n;k++){
            res[k] = input[k-1];
        }
        StringBuffer sb = new StringBuffer();
        for(int j=1;j<=n;j++){
            char c = (char) (res[j] +'0');
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
