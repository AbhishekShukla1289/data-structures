class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int[] res = new int[k];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        
        for(int keys : map.keySet()){
            heap.add(keys);
            if(heap.size() > k)
                heap.poll();
        }
        
        for(int i = k - 1; i >= 0; --i){
            res[i] = heap.poll();
        }
        
        return res;
    }
}