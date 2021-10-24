// 415. Add Strings
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        
        while(len1 >= 0 || len2 >= 0) {
            int n1 = (len1 >= 0) ? num1.charAt(len1) - '0' : 0;
            int n2 = (len2 >= 0) ? num2.charAt(len2) - '0' : 0;
            int currentVal = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            
            result.append(currentVal);
            len1--;
            len2--;
        }
        
        if(carry != 0)
            result.append(carry);
        
        return result.reverse().toString();
    }
}
