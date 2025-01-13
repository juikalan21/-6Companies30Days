class ThroneInheritance {
    Map<String, List<String>> map;
    Set<String> set;
    String king;

    public ThroneInheritance(String kingName) {
        map = new HashMap();
        set = new HashSet();
        map.putIfAbsent(kingName, new ArrayList());
        king = kingName;
        }
    
    public void birth(String parentName, String childName) {
        map.get(parentName).add(childName);
        map.putIfAbsent(childName, new ArrayList());
    }
    
    public void death(String name) {
        set.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList();
        dfs(king, result);
        return result;
    }
    
    private void dfs(String root, List<String> result) {
            if (!set.contains(root))
                result.add(root);
            for (String child : map.get(root))
                dfs(child, result);
    }
}
