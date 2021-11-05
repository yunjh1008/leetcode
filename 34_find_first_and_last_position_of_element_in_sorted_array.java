// 34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = findBound(nums, target, true);
        if(firstIdx == -1) {
            return new int[] {-1, -1};
        }
        
        int lastIdx = findBound(nums, target, false);
        
        return new int[] {firstIdx, lastIdx};
    }
    
    public int findBound(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int pivot = (start + end) / 2;
            
            if(nums[pivot] == target) {
                if(isFirst) {
                    // lower bound
                    if(pivot == start || nums[pivot-1] != target) {
                        return pivot;
                    }
                    
                    end = pivot - 1;
                }
                else {
                    // upper bound
                    if(pivot == end || nums[pivot+1] != target) {
                        return pivot;
                    }
                    
                    start = pivot + 1;
                }
            }
            else if(nums[pivot] > target) {
                end = pivot - 1;
            }
            else {
                start = pivot + 1;
            }
        }
        
        return -1;
    }
}
