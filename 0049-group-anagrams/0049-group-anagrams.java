class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String str = String.valueOf(ca);
            if(!map.containsKey(str))
                map.put(str, new ArrayList());
            map.get(str).add(strs[i]);
        }
        
        return new ArrayList(map.values());
    }
}