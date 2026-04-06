class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min heap based on capital    

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( (a,b) -> a[0] - b[0] );

        // Max heap based on profit 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> b - a);

    //     step 1: store Projects 

    for( int i = 0; i < profits.length; i++) {
        minHeap.add(new int[] {capital[i],profits[i]});
    }
    // Step 2 : Do K projects 
    for (int i = 0; i < k; i++) {
        // Move all affordable projects 
        while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
            maxHeap.add(minHeap.poll()[1]);
        }
        if (maxHeap.isEmpty()) break;
        
            w += maxHeap.poll();

            }
          
          return w;
    }
}