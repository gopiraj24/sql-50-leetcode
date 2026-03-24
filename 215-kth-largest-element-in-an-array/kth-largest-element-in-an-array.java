class Solution {
    public int findKthLargest(int[] nums, int k) {
     PriorityQueue<Integer> minHeap = new PriorityQueue<>();

     for (int num : nums) {
        minHeap.offer(num);
         
        // Keep only k elements
        if(minHeap.size() > k) {
            minHeap.poll();
        } 
     }
     return minHeap.peek();
    }
}