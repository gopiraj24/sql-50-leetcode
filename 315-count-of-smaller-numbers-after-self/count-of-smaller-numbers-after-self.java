import java.util.*;

class Solution {
    static class Fenwick {
        int[] tree;

        Fenwick(int size) {
            tree = new int[size + 1]; // 1-based indexing
        }

        // add value to index
        void update(int index, int value) {
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        // prefix sum query (sum from 1 to index)
        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;

        // Step 1: Coordinate compression (map nums to ranks)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            rankMap.put(sorted.get(i), i + 1); // ranks start from 1
        }

        // Step 2: Fenwick tree
        Fenwick fenwick = new Fenwick(sorted.size());
        int[] counts = new int[n];

        // Step 3: Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            int rank = rankMap.get(nums[i]);
            // query smaller elements (strictly less → rank - 1)
            counts[i] = fenwick.query(rank - 1);
            // add this number into fenwick
            fenwick.update(rank, 1);
        }

        // Convert to List<Integer>
        for (int c : counts) result.add(c);
        return result;
    }

    
}
