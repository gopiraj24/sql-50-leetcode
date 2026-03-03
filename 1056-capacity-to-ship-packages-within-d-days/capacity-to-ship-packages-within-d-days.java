class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = 0;
        int right = 0;
        for(int w : weights) {
            right += w;
            left = Math.max(w, left);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(canShip(weights, days, mid)) {
                ans = mid;
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return ans;
    }
    private  boolean canShip(int[] weights, int days, int max) {
        int count = 1;
        int sum = 0;
        for (int w : weights) {
            if(sum + w <= max) {
               sum += w;
            } else {
                sum = w;
                count++;
            }

        }

        return count <= days;
    }
}