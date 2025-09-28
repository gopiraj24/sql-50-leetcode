import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] nse = new int[N];
        int[] pse = new int[N];

        nxt_small(heights, nse);
        prev_small(heights, pse);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }

    // Next Smaller Element (indices)
    public void nxt_small(int[] heights, int[] nse) {
        int N = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? N : st.peek(); // if no NSE → set to N
            st.push(i);
        }
    }

    // Previous Smaller Element (indices)
    public void prev_small(int[] heights, int[] pse) {
        int N = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek(); // if no PSE → set to -1
            st.push(i);
        }
    }
}
