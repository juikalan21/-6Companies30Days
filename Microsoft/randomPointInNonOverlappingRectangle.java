class Solution {

    private int[][] rects;
    private Random random;
    private TreeMap<Integer, Integer> map;
    private int sum;

    public Solution(int[][] rects) {
        this.rects = rects;
        random = new Random();
        map = new TreeMap();
        sum = 0;

        for(int i = 0; i < rects.length; i++){
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }
    }
    public int[] pick(){
        int num = map.ceilingKey(random.nextInt(sum) + 1);
        int[] xy = rects[map.get(num)];
        return new int[]{xy[0] + random.nextInt(xy[2] - xy[0] + 1), xy[1] + random.nextInt(xy[3] - xy[1] + 1)};
    }
}
