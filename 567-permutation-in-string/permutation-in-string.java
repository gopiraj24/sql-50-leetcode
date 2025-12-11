class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(char c: s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int window = s1.length();
        
        for(int i = 0; i<s2.length();i++) {
         s2Count[s2.charAt(i) - 'a']++;

         if (i >= window) {
            s2Count[s2.charAt(i - window) - 'a']--;
         }


         if(i>=window-1) {
            if(Arrays.equals(s1Count,s2Count)) {
                return true;
            }
         }
        }
        return false;
    }
}