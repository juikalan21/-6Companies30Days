class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;

        for (int mask1 = 1; mask1 < (1 << n); mask1++) {
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask1 & (1 << i)) != 0) {
                    sb1.append(s.charAt(i));
                }
            }
            if (!isPalindrome(sb1.toString())) {
                continue;
            }
            int len1 = sb1.length();

            for (int mask2 = 1; mask2 < (1 << n); mask2++) {
                if ((mask1 & mask2) != 0) {
                    continue; 
                }
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if ((mask2 & (1 << i)) != 0) {
                        sb2.append(s.charAt(i));
                    }
                }
                if (isPalindrome(sb2.toString())) {
                    int len2 = sb2.length();
                    maxProduct = Math.max(maxProduct, len1 * len2);
                }
            }
        }

        return maxProduct;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}