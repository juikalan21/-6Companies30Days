class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        for (int i = 0; i + 10 <= s.length(); i++) {
            String substring = s.substring(i, i + 10);
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }
        
        return new ArrayList<>(repeated);
    }
}
