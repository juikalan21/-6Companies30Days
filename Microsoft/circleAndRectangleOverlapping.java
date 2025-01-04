class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //finding nearest point from circle's center to rectangle
        int nearest_x = Math.max(x1, Math.min(x2, xCenter)); //finding min x
        int nearest_y = Math.max(y1, Math.min(y2, yCenter)); //finding min y

        //calculating distance between circle center and nearest point
        int dist_x = nearest_x - xCenter;
        int dist_y = nearest_y - yCenter;

        //checking if this distance is less than or equal to the circle's radius
        return (dist_x * dist_x + dist_y * dist_y) <= (radius * radius);
    }
}