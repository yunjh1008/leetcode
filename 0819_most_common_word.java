// 819. Most Common Word
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // [^a-zA-Z0-9] = \\W, [a-zA-Z0-9] = \\w
        // replace punctuations with spaces
        String normalizedStr = paragraph.replaceAll("\\W", " ");
        // put all letters in lower case
        normalizedStr = normalizedStr.toLowerCase();
        System.out.println(normalizedStr);
        
        Set<String> bannedWords = new HashSet<>();
        for(String word : banned) {
            bannedWords.add(word);
        }
        
        // split the string into words
        // some words separated by 1+ space(s)
        String words[] = normalizedStr.split("\\s+");
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        for(String word : words) {
            if(!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
