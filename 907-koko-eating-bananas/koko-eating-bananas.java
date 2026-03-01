class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles) {
            right = Math.max(right, pile);
        }
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2; 

            if(canFinish(piles, mid, h)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
       

    private boolean canFinish(int piles[], int k, int h) {
        long  hours = 0;

        for (int p : piles) {
            hours += (p + k -1) / k;
        }


        return hours <= h;
    }


}