class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevDay = st.pop();
                answer[prevDay] = i - prevDay;
            }
            st.push(i);
        }
         
         return answer;
        
    }
}