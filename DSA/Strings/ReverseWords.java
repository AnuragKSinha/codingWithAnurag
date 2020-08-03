package DSA.String;
/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class ReverseWords {
    public String reverseWords(String s) {
        if(s==null|| s=="")
            return s;
        char[] ch=s.toCharArray();
        String res="";
        reverse(ch);
        Stack<Character> stack=new Stack<>();
        boolean space=false;
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=' ' && res.length()>0 && space){
                res=res+" ";
                space=false;  
            }  
            if(ch[i]!=' '){
                stack.push(ch[i]);
            }
            else if(ch[i]==' ' && !stack.isEmpty()){
                while(!stack.isEmpty())
                    res=res+stack.pop();
                space=true;
            }      
        }
        while(!stack.isEmpty())
                    res=res+stack.pop();
        return res;
    }
    char[] reverse(char[] ch){
        int l=0;
        int r=ch.length-1;
        while(l<=r){
            char temp=ch[l];
            ch[l]=ch[r];
            ch[r]=temp;
            l++;
            r--;
        }
        return ch;
    }
}