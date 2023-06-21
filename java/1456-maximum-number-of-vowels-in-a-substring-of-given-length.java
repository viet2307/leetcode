/*
    Author: Viet2307
    Github: https://github.com/viet2307
    Name - Maximum Number of Vowels in a Substring of Given Length
    Link - https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    Time Complexity O(N)
    Space Complexity - O(1)
*/

class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length(), count = 0, maxCount = -1, start = 0;
        Set<Character> vowels = Set.of('a', 'i', 'u', 'e', 'o');
        String window = "";
        for(int end = 0; end < n; end++) {
            char c = s.charAt(end);
            if(vowels.contains(c)) count++;
            if(end-start+1 > k) {
                char rm = s.charAt(start);
                if(vowels.contains(rm)) count--;
                start++;
            }
            maxCount = Math.max(maxCount, count);
            maxCount = maxCount > k ? k : maxCount;
        }
        return maxCount;
    }
}