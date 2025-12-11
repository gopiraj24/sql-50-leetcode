class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Build freq of p 
        for(char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int window = p.length();

        for(int i = 0; i < s.length(); i++) {
            // Expand the window 
                 sCount[s.charAt(i) - 'a']++;

                 //  Shrink the window when size exceeds p 
                 if(i >= window) {
                    sCount[s.charAt(i - window) - 'a']--;
                 }

                 // compare when window size is reached 

                 if(i >= window -1) {
                    if(Arrays.equals(pCount,sCount)) {
                        res.add(i-window + 1);
                    }
                 }
        }
        return res;
    }
}