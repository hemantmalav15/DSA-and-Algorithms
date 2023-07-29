public class RangeQuery2dArr {
    // initialising object
    int res[][];
    public int[][] PrefixSum2dArr(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        res = new int[n][m];
        // finding prefix sum
        res[0][0] = matrix[0][0];
        // find prefix sum on first row
        for(int j = 1; j < m; j++){
            res[0][j] = res[0][j - 1] + matrix[0][j];
        }
        // find prefix sum on first col
        for(int i = 1; i < n; i++){
            res[i][0] = res[i - 1][0] + matrix[i][0];
        }
        // find prefix sum of rest of the elements
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1] + matrix[i][j] - res[i - 1][j - 1];
            }
        }
        return res;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0){
            return res[row2][col2];
        }
        else if(row1 == 0){
            return res[row2][col2] - res[row2][col1 - 1];
        }
        else if(col1 == 0){
            return res[row2][col2] - res[row1 - 1][col2];
        }
        else{
            return res[row2][col2] - res[row1 - 1][col2] - res[row2][col1 - 1] + res[row1 - 1][col1 - 1];
        }
    }
}
