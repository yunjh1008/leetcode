// 125. Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        // '_' is not included in "\\W"
        String normalizedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean result = true;
        
        for(int i = 0; i < normalizedStr.length(); i++) {
            if(normalizedStr.charAt(i) != normalizedStr.charAt(normalizedStr.length() - 1 - i)) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}
