class LRUCache {

    public int capacity;

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    private boolean isFull() {
        return capacity == cache.size();
    }

    public int get(int key) {
        //remove first from the cache
        int value = cache.get(key) != null? cache.remove(key) : -1;

        if(value != -1) {
            //put back
            cache.put(key, value);
        }

        return value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            //remove, then put back (this will affect order)
            cache.remove(key);
        } else {
            if(isFull()) {
                //remove first item
                int firstItemKey = cache.entrySet().iterator().next().getKey();
                cache.remove(firstItemKey);
            }
        }
        cache.put(key, value);
    }
}