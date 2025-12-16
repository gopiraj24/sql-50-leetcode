class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int rem = 0;
        map.put(0,-1);
        for(int i = 0; i < n; i++) {
             sum+= nums[i];
             rem = sum % k;
            
            if(map.containsKey(rem)) {
                if((i - map.get(rem))>=2) {
                    return true;
                }
            }else{
            map.put(rem, i);
            }
        }
        return false;
    }
}