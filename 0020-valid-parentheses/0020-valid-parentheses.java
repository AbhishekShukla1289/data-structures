class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0 || s == null)
            return false;
        
        Stack<Character> st = new Stack<>();
        int i = 0;
        
        while (i < s.length()) {
            char ca = s.charAt(i);
            
            if (ca == '(' || ca == '{' || ca == '[')
                st.push(ca);
            else if (ca == ')') {
                if (st.isEmpty() || st.peek() != '(')
                    return false;
                st.pop();
            } else if (ca == '}') {
                if (st.isEmpty() || st.peek() != '{')
                    return false;
                st.pop();
            } else if (ca == ']') {
                if (st.isEmpty() || st.peek() != '[')
                    return false;
                st.pop();
            }
            
            i++;
        }
        
        return st.isEmpty();
    }
}
