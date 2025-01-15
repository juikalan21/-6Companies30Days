class Solution {
    public long sumScores(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, l=0, r=0; 
        int[] z = new int[n];
        long result = n;
        for(int i =1; i<n; i++){
            z[i] = Math.max(0, Math.min(z[i-l], r-i+1));
            while(i+z[i] < n && arr[z[i]] == arr[i+z[i]]){
                l = i;
                r = i +z[i];
                z[i]++;
            }
            result += z[i];
        }   
        return result;    
    }
}