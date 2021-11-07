// 496. Next Greater Element I
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++) {
            boolean found = false;
            int j;
            for(j = 0; j < nums2.length; j++) {
                if(found && nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
                
                if(nums1[i] == nums2[j]) {
                    found = true;
                }
            }
            
            if(j == nums2.length) {
                result[i] = -1;
            }
        }
        
        return result;
    }
}
