import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wangtaishan
 * Date : 2018/9/1
 * Title : 48. Rotate Image
 * Description :
 *
 *You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * Analysis :
 *
 *
 */

public class RotateImage {
    public void stupid_rotate(int[][] matrix) {
        if(matrix.length < 1 || matrix == null) return;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                list.add(matrix[i][j]);

        int row_len = matrix.length;
        int col_len = matrix[0].length;
        for(int i = 0; i < list.size(); i++){
            int row = i % col_len;
            int col = col_len - i / col_len - 1;
            matrix[row][col] = list.get(i);
        }
    }


}
