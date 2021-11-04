package JD;

import java.util.Scanner;

/*
机器人大战
时间限制： 3000MS
内存限制： 589824KB
题目描述：
你的朋友向你介绍了一款游戏叫《机器人大战》。

游戏开局会自动生成一个n行m列的矩阵，视作游戏地图，一些位置上有敌人设置的炮塔。你的任务是摧毁敌人所有的炮塔。幸运的是，这些炮塔之间的联系早已被切断，即摧毁一个炮塔不会影响其他炮塔的行动。

由于你才开始游玩该游戏，所以你手上只有一个机器人。你需要派出该机器人到矩阵任意空地。目前该机器人只有一种攻击方式：开火。每次开火会摧毁该机器人面向方向的第一个炮塔。消灭之后，该地变为空地。

由于紧急指令，机器人可能会未消灭完所有的炮塔之后被立即召回。现在，你需要记录下你的所有行动指令并交给指挥官，指挥官才能够分析地图上的局势如何。



输入描述
第一行两个空格隔开的正整数n,m；

接下来一个n行m列的矩阵aij，表示地图的局势。aij=0表示该地为空地，aij=1表示该地有一炮塔。

接下来一行为sx，sy，sc，其中（sx，sy）表示机器人初始位置，sc表示机器人初始朝向，空格隔开。

最后一行一个字符串，字符串仅包含“WASDwasdZ”九种字符，其中：

W表示机器人从(i,j)走向(i-1,j)，即往上走；

A表示机器人从(i,j)走向(i,j-1)，即往左走；

S表示机器人从(i,j)走向(i+1,j)，即往下走；

D表示机器人从(i,j)走向(i,j+1)，即往右走;

其中，如果走向的下一步越过矩阵边界或者为炮塔，则你的程序需要忽略该指令。另外，执行上述指令时机器人的朝向不变。

w表示改变机器人的朝向为上；

a表示改变机器人的朝向为左；

s表示改变机器人的朝向为下；

d表示改变机器人的朝向为右；

Z表示开火。



2≤n，m≤400，1≤sx≤n，1≤sy≤m,sc∈{'w','a','s'1'd'},1≤指令长度≤103，aij∈{0,1}

输出描述
输出一个n行m列的矩阵，表示执行完所有指令后的矩阵。同一行中不输出任何空格。

样例输入
5 5
00100
11000
00101
11001
00111
2 3 w
ZsZSZdZ
样例输出
00000
11000
00000
11001
00011

 */
public class JD2 {
    static int[][] map;
    static int posX;
    static int posY;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i=0;i<n;i++){
            String str = sc.next();
            for(int j =0;j<str.length();j++){
                map[i][j] = str.charAt(j) -'0';
            }
        }
        posX = sc.nextInt()-1;
        posY = sc.nextInt()-1;
        String face = sc.next();
        String instruct = sc.next();
        for(char c:instruct.toCharArray()){
            switch (c){
                case 'Z':fire(face);break;
                case 'W':
                case 'A':
                case 'S':
                case 'D':move(c);break;
                case 'w':face = "w";break;
                case 's':face = "s";break;
                case 'a':face = "a";break;
                case 'd':face = "d";break;
                default:break;
            }
        }

        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<m;j++){
                sb.append(map[i][j]);
            }
            System.out.println(sb.toString());
        }
    }

    public static void fire(String face){
        switch (face){
            case "w":fireW();break;
            case "a":fireN();break;
            case "d":fireS();break;
            case "s":fireE();break;
            default:
        }
    }

    private static void fireS() {
        for(int i=posY;i<m;i++){
            if(map[posX][i] == 1){
                map[posX][i]=0;
                break;
            }
        }
    }

    private static void fireN() {
        for(int i=posY;i>=0;i--){
            if(map[posX][i] == 1){
                map[posX][i]=0;
                break;
            }
        }
    }

    public static void fireW(){
        for(int i=posX;i>=0;i--) {
            if (map[i][posY] == 1) {
                map[i][posY] = 0;
                break;
            }
        }
    }

    public static void fireE() {
        for (int i = posX; i < n; i++) {
            if (map[i][posY] == 1) {
                map[i][posY] = 0;
                break;
            }
        }
    }

    public static void move(char pos){
        switch (pos){
            case 'S':
                if(posX+1<n && map[posX+1][posY] != 1){
                    posX++;
                }
                break;
            case 'W':
                if(posX -1>=0 && map[posX-1][posY]!=1){
                    posX--;
                }
                break;
            case 'A':
                if(posY -1 >=0&& map[posX][posY-1]!=1){
                    posY--;
                }
                break;
            case 'D':
                if(posY+1<n && map[posX][posY+1] !=1){
                    posY++;
                }
                break;
        }
    }

}
