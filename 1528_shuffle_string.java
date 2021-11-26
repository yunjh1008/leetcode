// 1528. Shuffle String
class Solution {
    public String restoreString(String s, int[] indices) {        
        StringBuilder strBuilder = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            strBuilder.setCharAt(indices[i], s.charAt(i));
        }
        
        return strBuilder.toString();
    }
}
