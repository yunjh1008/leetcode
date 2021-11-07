// 409. Longest Palindrome
class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] letters = new int[128];
        
        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        
        // how to calculate: "ccccc" = 4 ((5/2) = 2 * 2)
        for(int count : letters) {
            result += (count / 2) * 2;
            if(result % 2 == 0 && count % 2 == 1) {
                result++;
            }
        }
        
        return result;
    }
}
