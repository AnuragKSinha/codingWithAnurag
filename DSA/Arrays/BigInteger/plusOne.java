package DSA.Arrays.BigInteger;
/**
 * https://leetcode.com/problems/plus-one/
 * Space Complexity:O(1)
 * Time Complexity:(n)
 */
class plusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length==0)
            return new int[]{0};
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9)
                digits[i]=0;
            else{
                digits[i]++;
                return digits;
            }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}