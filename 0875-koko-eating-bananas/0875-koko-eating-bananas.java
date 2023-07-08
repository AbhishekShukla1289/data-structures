class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        
        for(int pile : piles){
            high = Math.max(pile, high);
        }
        
        while(low < high){
            int mid = (high + low) / 2;
            
            int hours = 0;
            for(int p : piles){
                hours += Math.ceil((double)p / mid);
            }
            if(hours > h)
                low = mid + 1;
            else
                high = mid;
                
        }
        return high;
    }
}