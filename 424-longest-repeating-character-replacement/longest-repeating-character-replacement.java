class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for(int right = 0; right<s.length();right++){
            char c = s.charAt(right);
            freq[c-'A']++;

            // Track the highest frequency character inside current window 

            maxFreq = Math.max(maxFreq,freq[c-'A']);

            // If Window becomes invalid. shrink it 
            int windowSize = right - left +1;
            if(windowSize - maxFreq > k) {
                freq[s.charAt(left)-'A']--;
                left++;
            }
            //Update max length of valid window 
            maxLen = Math.max(maxLen, right-left + 1);
        }
        return maxLen;
    }
}