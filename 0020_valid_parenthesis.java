// 20. Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // closing bracket
            if(map.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                
                // invalid order
                if(top != map.get(c)) {
                    return false;
                }
            }
            // opening bracket
            else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
