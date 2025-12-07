class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        // freq map for t 

        int[] freq = new int[128];
        
        for(char c : t.toCharArray()) {
            freq[c]++;
        }

        int required = t.length(); // total chars we still need to match 
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        

        //sliding window
        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            // if this character is needed reduce requirement
            if(freq[rc] > 0) {
                required--;
            }

            freq[rc]--; // reduce count (can go negative if extra chars found)

            // when window is valid -> shrink from left 

            while(required == 0){
                // update min window 
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char lc = s.charAt(left);
                freq[lc]++;

                //if this char was actually needed , window becomes invalid
                if(freq[lc] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex,startIndex + minLen);
    }
}