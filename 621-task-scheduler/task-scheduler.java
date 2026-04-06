class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
    //  count frequency 

    for(char task : tasks) {
        freq[task - 'A']++;
    }

    // find max frequency 

    int maxFreq = 0;
    
    for (int f : freq) {
        maxFreq = Math.max(maxFreq, f);
    }

    int countMax = 0;
    for (int f : freq) {
        if(f == maxFreq) countMax++;
    }

    int result = (maxFreq - 1) * (n + 1) + countMax;


    // final answer 
    return Math.max(tasks.length, result);
        
    }
}