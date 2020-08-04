package DSA.String;
/**
 * https://leetcode.com/problems/valid-palindrome/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class ValidPalindrom {
    public boolean isPalindrome(String s) {
        if(s==null||s=="")
            return true;
        int l=0;
        int r=s.length()-1;
        while(l<=r){
          if(isAlphaNumeric(s.charAt(l)) && isAlphaNumeric(s.charAt(r))){
              if(toLowerCase(s.charAt(l))!=toLowerCase(s.charAt(r)))
                    return false;
          }else if(!isAlphaNumeric(s.charAt(l))){
              l++;
              continue;
          }else if(!isAlphaNumeric(s.charAt(r))){
              r--;
              continue;
          }
         l++;
         r--;
        }
        return true;
    }
    char toLowerCase(char ch){
        if(ch>='a' && ch<='z')
            return ch;
        else if(ch>='A' && ch<='Z'){
            char diff=(char)((ch-'A')+'a');
            return diff;
        }
        return ch;
    }
    boolean isAlphaNumeric(char ch){
        if(ch>='a' && ch<='z')
            return true;
        if(ch>='A' && ch<='Z')
            return true;
        if(ch>='0' && ch<='9')
            return true;
        return false;
    }
}