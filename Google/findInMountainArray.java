class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
          // Find Peak of Mountain
        int peakIdx = findPeak(mountainArr);
        // Now BS in left_ASC and right_DSC range
        int res = -1;
        // // EDGE CASE 
        if(target > mountainArr.get(peakIdx))  return -1;
        res = BS_ASC(target, mountainArr, 0, peakIdx);
        if(res != -1) return res;
        return BS_DSC(target, mountainArr, peakIdx, mountainArr.length()-1);
        
    }
    
    private int BS_ASC(int target, MountainArray arr, int st, int ed) {
        while(ed>=st) {
            int mid = st + (ed-st)/2;
            if(arr.get(mid) == target) {
                return mid;
            } else if(arr.get(mid) > target) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return -1;
    }
    
    private int BS_DSC(int target, MountainArray arr, int st, int ed) {
        while(ed>=st) {
            int mid = st + (ed-st)/2;
            if(arr.get(mid) == target) {
                return mid;
            } else if(arr.get(mid) > target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }
    
    private int findPeak(MountainArray arr) {
        int st = 0;
        int ed = arr.length() - 1;
        
        while(ed>=st) {
            int mid = st + (ed-st)/2;
            if(mid == 0) return 1;
            if(arr.get(mid-1) < arr.get(mid) && arr.get(mid) > arr.get(mid+1)) {
                return mid;
            } else if(arr.get(mid-1) < arr.get(mid) && arr.get(mid) < arr.get(mid+1)) {
                st = mid+1;
            } else {
                ed = mid-1;
            }
        }
        return -1;
    }
}