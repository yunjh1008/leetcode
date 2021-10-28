// 3. Longest Substring without Repeating Characters
class Solution {
    // brute force: O(n^3) - time limit exceeded
    public int lengthOfLongestSubstringBruteForce(String s) {
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(checkRepetition(s, i, j)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        
        return result;
    }
    
    boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];
        
        for(int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            
            if(chars[c] > 1) {
                return false;
            }
        }
        
        return true;
    }
    // brute force
    
    // sliding window algorithm - O(2n) = O(n)
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int result = 0;
        
        while(right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            
            while(chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            
            result = Math.max(result, right - left + 1);
            right++;
        }
        
        return result;
    }
}
