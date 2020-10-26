/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Space Complexity:O(1)
 * Time Complexity:O(n)
 */
class StringToInteger {
    public int myAtoi(String s) {
        int i=0;
        int sign=1;
        int result=0;
        if(s==null || s.length()==0)
            return result;
        // removing spaces
        while(i<s.length() && s.charAt(i)==' ')
            i++;
        //sign
        if(i<s.length() && (s.charAt(i)=='+'||s.charAt(i)=='-'))
            sign=s.charAt(i++)=='-'?-1:1;
        // checking overflow or underflow conditions
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && s.charAt(i)-'0' >Integer.MAX_VALUE%10)){
                result=sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
                break;
            }
            result=result*10+s.charAt(i++)-'0';
        }
        return result*sign;  
    }
}