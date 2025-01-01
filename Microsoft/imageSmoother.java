class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        
        int[] directionsX = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] directionsY = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                
                for (int d = 0; d < 9; d++) {
                    int ni = i + directionsX[d];
                    int nj = j + directionsY[d];
                    
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        sum += img[ni][nj];
                        count++;
                    }
                }
                
                result[i][j] = sum / count;
            }
        }
        
        return result;
    }
}