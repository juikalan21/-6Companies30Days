class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] countS = new int[10];
        int[] countG = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                countS[s - '0']++;
                countG[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(countS[i], countG[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
