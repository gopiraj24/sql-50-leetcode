class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointer1 = 0;
        int pointer2 = 0;
        int k = s.length();
        int r = t.length();
        

        while(pointer1 < k && pointer2 <r ) {
            char c = t.charAt(pointer2);
            if(s.charAt(pointer1) == c ) {
                pointer1++;
            }
          
            pointer2++;
        }
       return s.length()== pointer1;
        
    }
}