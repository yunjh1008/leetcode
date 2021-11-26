// 1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] result = new int[2];
        
        // 1. brute force - O(n^2)
        // Space: O(C)
        // for(int i = 0; i < nums.length-1; i++) {
        //     for(int j = i+1; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             result[0] = i;
        //             result[1] = j;
        //         }
        //     }
        // }
        
        // 2. two-pass hash table - O(n)
        // Space: O(n)
        // create hash table
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++) {
//             map.put(nums[i], i);
//         }
        
//         for(int i = 0; i < nums.length; i++) {
//             int complement = target - nums[i];
            
//             if(map.containsKey(complement) && map.get(complement) != i) {
//                 return new int[] {i, map.get(complement)};
//             }
//         }
        
//         throw new IllegalArgumentException("No two sum solution");
        
        // 3. one-pass hash table - O(n)
        // Space: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i); 
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}
