class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, oddCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            if (map.containsKey(oddCount - k)) {
                count += map.get(oddCount - k);
            }
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }
        return count;
    }
}