class Solution {
    // 1. Brute Force - O(n^3)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            else if(!stack.empty() && stack.peek() == '(') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }
    
    public int longestValidParenthesesBruteForce(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+2; j <= s.length(); j++) {
                if(isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        
        return maxLen;
    }
    // Brute Force
    
    // Using stack - O(n)
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if(stack.empty()) {
                    stack.push(i);
                }
                else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}
