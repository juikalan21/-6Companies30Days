class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        
        int time = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;
            
            for (int i = 0; i < size; i++) {
                int[] rottenLoc = queue.poll();
                int r = rottenLoc[0];
                int c = rottenLoc[1];
                
                for (int[] direction : directions) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1) {
                        continue;
                    }
                    
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    freshCount--;
                    rottenThisMinute = true;
                }
            }
            
            if (rottenThisMinute) {
                time++;
            }
        }
        
        return freshCount == 0 ? time : -1;
    }
}
