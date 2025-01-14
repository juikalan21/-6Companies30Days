class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // initialize the distance matrix - 2D Array
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2; // Using large value (+ infinity)
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
        }

        for (int k = 0; k < n; k++) { //using floyd warshall algorithm
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        //finding the city 
        int minCity = -1;
        int minNeighbors = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            // Updating the result city 
            if (count < minNeighbors || (count == minNeighbors && i > minCity)) {
                minNeighbors = count;
                minCity = i;
            }
        }

        return minCity;
    }
}

