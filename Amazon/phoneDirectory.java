
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        TreeSet<String> contactSet = new TreeSet<>(Arrays.asList(contact));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        String prefix = ""; 
        for (char c : s.toCharArray()) {
            prefix += c;
            ArrayList<String> matches = new ArrayList<>();
            
            for (String name : contactSet) {
                if (name.startsWith(prefix)) {
                    matches.add(name);
                }
            }
            
            if (matches.isEmpty()) {
                matches.add("0");
            }
            
            result.add(matches);
        }
        
        return result;
    }
}
