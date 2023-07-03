class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int res[] = new int[temperatures.length];
        
        Stack<Integer> st = new Stack<>();
        
        int n = temperatures.length;
        
        for(int i = 0; i < n; i++){     
            int currTemp = temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()] < currTemp){
                int prevDay = st.pop();
                res[prevDay] = i - prevDay;
            }
            st.push(i);
        }
        
        return res;
    }
}