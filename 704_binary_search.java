// 704. Binary Search
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = 0;
        
        while(left <= right) {
            // get pivot index
            pivot = (left + right) / 2;
            
            if(nums[pivot] == target)
                return pivot;
            
            // find in left side of pivot
            if(target < nums[pivot])
                right = pivot - 1;
            // find in right side of pivot
            else
                left = pivot + 1;
        }
        
        return -1;
    }
}
