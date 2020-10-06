package DSA.Stack;
/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Space Complexity: O(n) --> O(3n)
 * Time Complexity: O(n)
 */
class RemoveInValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb=new StringBuffer();
        Stack<Integer> stack=new Stack<>();
        Set<Integer> removeInvalid=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty()) 
                    removeInvalid.add(i);
                else
                    stack.pop();
            }     
        }
        while(!stack.isEmpty())
            removeInvalid.add(stack.pop());
        for(int i=0;i<s.length();i++){
            if(!removeInvalid.contains(i))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}