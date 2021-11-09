package Offer;

public class O013 {
    int[][] sum;
    /*
        方法一：一维前缀和
        对每行计算前缀和
        求和的时间复杂度O（m） 和行数有关
     */
    public void NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m>0){
            int n = matrix[0].length;
            sum = new int[m][n+1];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    sum[i][j+1] = sum[i][j] +matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i=row1;i<=row2;i++){
            res +=sum[i][col2+1]-sum[i][col1];
        }
        return res;
    }

    /*
    方法二
    二维前缀和
    计算方法：f(i,j)=f(i−1,j)+f(i,j−1)−f(i−1,j−1)+matrix[i][j]
    查找时间复杂度O（1）
     */

    int[][] sums;
    public void NumMatrix2(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }

}
