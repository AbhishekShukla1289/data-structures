class Solution {
    public List<String> generateParenthesis(int n) {
        //Stack<String> st = new Stack<>();
        
        List<String> res = new ArrayList<>();
        
        backtrack(res, new StringBuilder(), 0, 0, n);
        
        return res;
    }
    
    public void backtrack(List<String> li, StringBuilder curString, int openB, int closedB, int n){ 
        
        if(curString.length() == 2 * n){
            li.add(curString.toString());
            return;
        }
        if(openB < n){
            curString.append("(");
            backtrack(li, curString, openB + 1, closedB, n);
            curString.deleteCharAt(curString.length() - 1);
        }
        if(closedB < openB){
            curString.append(")");
            backtrack(li, curString, openB, closedB + 1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
}