class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0; //mountain requires 3 elements
        }
        
        int longest = 0;
        int i = 1; //start from the second element to avoid out bounds

        while (i < n - 1) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                int mountainLength = right - left + 1;
                longest = Math.max(longest, mountainLength);
                
                i = right;
            } else {
                i++;
            }
        }

        return longest;
    }
}