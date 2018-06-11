/**
 * 题目：661. Image Smoother 给一个图像的灰度矩阵，对每个点做模糊滤波（九个点取平均值）。
 *
 * 分析：这道题重点要分析图像周边点的情况。因此需要对每个点周围的八个点进行分析，只有坐标在图像内可以累加sum，并计数count
 *      最后 sum/count 就是每个点点结果。easy 题，结果自己答案其实写复杂了。。。
 */

class ImageSmooth {
    public int[][] imageSmoother(int[][] M) {

        int row = M.length;
        int col = M[0].length;
        int[][] scaled = new int[row + 2][col + 2];

        for(int i = 0; i < row + 2; i++)
            for(int j = 0; j < col + 2; j++)
                scaled[i][j] = -1;

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                scaled[i + 1][j + 1] = M[i][j];

        for(int i = 1; i < row + 1; i++)
            for(int j = 1; j < col + 1; j++){
                int count = 0;
                int sum = 0;
                for(int m = i - 1; m < i + 2; m++)
                    for(int n = j - 1; n < j + 2; n++){
                        if(scaled[m][n] != -1){
                            sum += scaled[m][n];
                            count++;
                        }
                    }
                M[i - 1][j - 1] = sum / count;
            }
        return M;
    }
}