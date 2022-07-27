class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int low = 0;
        int high = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(high < s.length())
        {
            char c = s.charAt(high);
            if(map.containsKey(c) && map.get(c) >= low){
                max = Math.max(max,high - low);
                low = map.get(c) + 1;
                map.put(c, high);
            }
            else{
                map.put(c,high);
            }
            high++;
        }
        
        max = Math.max(max,high - low);

        return max;
    }
}
