import java.util.ArrayList;

class Solution {
    public int findTheWinner(int n, int k) {
        int index = 0;
        ArrayList<Integer> arr = new ArrayList<>(n);

        for(int i = 0; i<n; i++)
            arr.add(i);
        while(arr.size() > 1)
        {
            index = index + (k-1);
            index = index % arr.size(); //to wrap
            arr.remove(index);
        }
        return arr.get(0) +  1;
    }
}
