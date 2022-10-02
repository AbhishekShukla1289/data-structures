class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null) return 0;
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        for(int i = 0; i <  s.length(); i++){
            Character c = s.charAt(i);
            if(hm.containsKey(c)){
                left = Math.max(left, hm.get(c)); // move the left or start pointer to the start of new substring
            }
            max = Math.max(max, i - left + 1);
            hm.put(c, i+1);
        }
        return max;
    }
}