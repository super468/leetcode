/**
 * Creator : wts
 * Date : 6/22/18
 * Title : 240. Search a 2D Matrix II
 * Description :
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 *
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 * Analysis : 这道题没想到太好的方法，参考来别人的思路，O(M+N).
 *
 * 找到右上角的点，将target与其做比较，如果比target大，这个点以下的点都不用看了
 * 如果比target小，这个点左边的就不用看了
 *
 */

public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1) return false;
        int row = 0;
        if(matrix[0].length < 1) return false;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col > -1){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }

        return false;
    }
}
