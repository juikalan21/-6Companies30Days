class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set=new  HashSet();
        for(String s: startWords){
            char[] charStr=s.toCharArray();
            Arrays.sort(charStr);
            // will store all the strings in stored order
            set.add(new String(charStr));
        }
        int count=0;
        for(String t: targetWords){
            int n = t.length();
            for(int i=0;i<n;i++){
                String reducedStr= t.substring(0, i) + t.substring(i+1); // skip ith index
                char[] charStr =reducedStr.toCharArray();
                Arrays.sort(charStr);
                String storedStr = new String(charStr);
                if(set.contains(storedStr)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}