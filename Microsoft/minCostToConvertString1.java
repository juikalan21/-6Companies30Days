class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26]; // 26 lowercase characters
        for (long[] i : dist) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math
                    .min(dist[from][to], cost[i]);
        }
        //floyd warshall
        for(int node = 0; node < 26; node++){
            for(int u=0; u < 26; u++){
                for(int v=0; v < 26; v++){
                    if(u==v) continue;
                    dist[u][v] = Math.min(dist[u][node] + dist[node][v], dist[u][v]);
                }
            }
        }
        long ans = 0;
        for(int i=0; i < source.length(); i++){
            if(source.charAt(i)==target.charAt(i)) continue;
            if(dist[source.charAt(i)-'a'][target.charAt(i)-'a'] >= Integer.MAX_VALUE) return -1;
            ans += dist[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return ans;
    }
}
