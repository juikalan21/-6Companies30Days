class Solution {
    public int firstUniqChar(String s) {
        int[] count=new int[26];
        for(char ch:s.toCharArray())
            count[ch-'a']++;

        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(count[ch-'a']==1)
                return i;
        }
        return -1;
    }
}

